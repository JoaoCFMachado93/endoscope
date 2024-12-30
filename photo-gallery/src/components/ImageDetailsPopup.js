import React, { useState } from "react";
import "./ImageDetailsPopup.css";
import { useAuth } from "./AuthProvider";
import { backendBaseUrl } from "../config";

const ImageDetailsPopup = ({
  imageId,
  imageData,
  imageDescription,
  uploadedBy,
  uploadDate,
  state,
  onClose,
  onDescriptionUpdate, // Same function used to refresh images after state change
}) => {
  const [zoomLevel, setZoomLevel] = useState(1);
  const [description, setDescription] = useState(imageDescription);
  const [isEditing, setIsEditing] = useState(false);
  const { getUser } = useAuth();
  const user = getUser();
  const isAdmin = user && user.role.toUpperCase() === "ADMIN";

  const handleZoomIn = () => setZoomLevel(zoomLevel + 0.1);
  const handleZoomOut = () => setZoomLevel(zoomLevel - 0.1);

  const handleImageClick = () => {
    const imageDataUint8 = Uint8Array.from(atob(imageData), c => c.charCodeAt(0));
    const blob = new Blob([imageDataUint8], { type: "image/png" });
    const imageUrl = URL.createObjectURL(blob);
    window.open(imageUrl, "_blank");
  };

  const handleDescriptionChange = (event) => setDescription(event.target.value);

  const handleSaveDescription = async () => {
    try {
      if (!user) throw new Error("User not logged in");

      const response = await fetch(`${backendBaseUrl}/images`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${user.token}`,
        },
        body: JSON.stringify({ imageId, description }),
      });

      if (!response.ok) throw new Error("Failed to update image description");

      onDescriptionUpdate(); // Notify parent to refresh images
      setIsEditing(false);
      onClose(); // Close the popup 
    } catch (error) {
      console.error("Error updating image description:", error);
    }
  };

  const handleApprove = async () => {
    try {
      if (!user) throw new Error("User not logged in");

      const response = await fetch(`${backendBaseUrl}/images/${imageId}/state`, {
        method: "PUT",
        headers: {
          "Authorization": `Bearer ${user.token}`,
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ state: "APPROVED" }), // Set state to "APPROVED"
      });

      if (!response.ok) throw new Error("Failed to approve image");

      onDescriptionUpdate(); // Notify parent to refresh images after approval
      onClose(); // Close the popup after approval
    } catch (error) {
      console.error("Error approving image:", error);
    }
  };

  const handleDeny = async () => {
    try {
      if (!user) throw new Error("User not logged in");

      const response = await fetch(`${backendBaseUrl}/images/${imageId}/state`, {
        method: "PUT",
        headers: {
          "Authorization": `Bearer ${user.token}`,
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ state: "DENIED" }), // Set state to "DENIED"
      });

      if (!response.ok) throw new Error("Failed to deny image");

      onDescriptionUpdate(); // Notify parent to refresh images after denial
      onClose(); // Close the popup after approval
    } catch (error) {
      console.error("Error denying image:", error);
    }
  };

  return (
    <div className="image-details-popup-overlay" onClick={onClose}>
      <div className="image-details-popup-container" onClick={(e) => e.stopPropagation()}>
        <button className="close-button" onClick={onClose}>X</button>
        <div className="enlarged-image-wrapper" style={{ height: `${60 * zoomLevel}%` }}>
          <img
            src={`data:image/png;base64,${imageData}`}
            alt="myImage"
            className="enlarged-image"
            style={{ transform: `scale(${zoomLevel})` }}
            onClick={handleImageClick}
          />
        </div>
        <div className="image-controls">
          <button onClick={handleZoomIn}>Zoom In</button>
          <button onClick={handleZoomOut}>Zoom Out</button>
        </div>
        <div className="image-details-container">
          <p>Upload Date: {new Date(uploadDate).toLocaleDateString()}</p>
          <p>Uploaded By: {uploadedBy}</p>
          
          {state === "PENDING" && isAdmin && (
            <div className="approve-deny-buttons">
              <button className="btn approve-btn" onClick={handleApprove}>Approve</button>
              <button className="btn deny-btn" onClick={handleDeny}>Deny</button>
            </div>
          )}

          {isAdmin && isEditing ? (
            <div>
              <textarea
                className="description-textarea"
                value={description}
                onChange={handleDescriptionChange}
              />
              <div className="button-group">
                <button className="btn save-btn" onClick={handleSaveDescription}>Save</button>
                <button className="btn cancel-btn" onClick={() => setIsEditing(false)}>Cancel</button>
              </div>
            </div>
          ) : (
            <div>
              <textarea
                className="description-textarea"
                value={description}
                readOnly
              />
              {isAdmin && <button className="btn edit-btn" onClick={() => setIsEditing(true)}>Edit description</button>}
            </div>
          )}
        </div>
      </div>
    </div>
  );
};

export default ImageDetailsPopup;

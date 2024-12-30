import React, { useState } from "react";
import { useAuth } from "./AuthProvider";
import "./AddImagePopup.css"; // Import the CSS file
import { backendBaseUrl } from "../config";

const AddImagePopup = ({ directoryId, onClose }) => {
  const [imageData, setImageData] = useState("");
  const [imageName, setImageName] = useState("");
  const [imageDescription, setImageDescription] = useState("");
  const { getUser } = useAuth();

  const handleImageUpload = (event) => {
    const file = event.target.files[0];
    
    // Check if file exists and is an image
    if (file && file.type.startsWith("image/")) {
      const reader = new FileReader();
      reader.onloadend = () => {
        setImageData(reader.result);
      };
      reader.readAsDataURL(file);
    } else {
      console.error("Invalid file format or no file selected.");
    }
  };

  const handleSubmit = async (event) => {
    event.preventDefault(); // Prevent default form submission behavior

    // Ensure all required fields are filled
    if (!imageName || !imageData) {
      alert("Please provide both image name and image data.");
      return;
    }

    try {
      const user = getUser();
      if (!user) {
        throw new Error("User not logged in");
      }

      const isAdmin = user && user.role.toUpperCase() === "ADMIN"; // Determine if the user is an admin

      const base64String = imageData.split(",")[1]; // Split at comma and get the second part

      const formData = {
        imageName,
        directory: directoryId, // Include directoryId
        uploadedBy: user.name, // Change as needed
        uploadDate: Date.now(),
        description: imageDescription,
        imageData: base64String, // Use the extracted base64 string
        state: isAdmin ? "APPROVED" : "PENDING", // Set state based on user role
      };

      const response = await fetch(
        `${backendBaseUrl}/images/directory/${directoryId}`,
        {
          method: "PUT",
          headers: {
            Authorization: `Bearer ${user.token}`,
            "Content-Type": "application/json",
          },
          body: JSON.stringify([formData]), // Send formData as an array
        }
      );

      // Check if the request was successful
      if (response.ok) {
        // Optionally, handle success
        onClose(); // Close the popup
      } else {
        const errorDetails = await response.json(); // Check for detailed error message
        console.error("Failed to add image:", response.status, errorDetails);
      }
    } catch (error) {
      console.error("Error adding image:", error);
    }
  };

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal" onClick={(e) => e.stopPropagation()}>
        <button className="close-button" onClick={onClose}>
          X
        </button>
        <h2>Add Image</h2>
        <form onSubmit={handleSubmit}>
          <div className="input-group">
            <label htmlFor="image-upload">Upload Image</label>
            <input type="file" id="image-upload" onChange={handleImageUpload} />
          </div>
          <div className="input-group">
            <label htmlFor="image-name">Image Name</label>
            <input
              type="text"
              id="image-name"
              value={imageName}
              onChange={(e) => setImageName(e.target.value)}
            />
          </div>
          <div className="input-group">
            <label htmlFor="image-description">Image Description</label>
            <textarea
              id="image-description"
              value={imageDescription}
              onChange={(e) => setImageDescription(e.target.value)}
            ></textarea>
          </div>
          <div className="button-group">
            <button type="submit" className="submit-button">
              Add Image
            </button>
            <button type="button" className="cancel-button" onClick={onClose}>
              Cancel
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default AddImagePopup;

import React, { useState } from "react";
import { useAuth } from "./AuthProvider";
import "./EditAlbumPopup.css";
import { backendBaseUrl } from "../config";
import ConfirmDeleteModal from "./ConfirmDeleteModal";

const EditAlbumPopup = ({
  album,
  onClose,
  onAlbumUpdated,
  onAlbumDeleted
}) => {
  const [directoryName, setDirectoryName] = useState(album.directoryName);
  const [directoryPosition, setDirectoryPosition] = useState(
    album.directoryPosition
  );
  const [showConfirmDeleteModal, setShowConfirmDeleteModal] = useState(false);
  const { getUser } = useAuth();

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const user = getUser();
      if (!user) {
        throw new Error("User not logged in");
      }

      const response = await fetch(
        `${backendBaseUrl}/directories/${album.directoryId}`,
        {
          method: "POST",
          headers: {
            Authorization: `Bearer ${user.token}`,
            "Content-Type": "application/json"
          },
          body: JSON.stringify({ directoryName, directoryPosition })
        }
      );

      if (response.ok) {
        onAlbumUpdated();
        onClose();
      } else {
        console.error("Failed to edit album:", response.status);
      }
    } catch (error) {
      console.error("Error editing album:", error);
    }
  };

  const handleDelete = async () => {
    setShowConfirmDeleteModal(true);
  };

  const confirmDelete = async () => {
    try {
      const user = getUser();
      if (!user) {
        throw new Error("User not logged in");
      }

      const response = await fetch(
        `${backendBaseUrl}/directories/${album.directoryId}`,
        {
          method: "DELETE",
          headers: {
            Authorization: `Bearer ${user.token}`,
            "Content-Type": "application/json"
          }
        }
      );

      if (response.ok) {
        onAlbumDeleted();
        onClose();
      } else {
        console.error("Failed to delete album:", response.status);
      }
    } catch (error) {
      console.error("Error deleting album:", error);
    }
  };

  return (
    <div className="modal-overlay" onClick={onClose}>
      <div className="modal" onClick={(e) => e.stopPropagation()}>
        <button className="close-button" onClick={onClose}>
          X
        </button>
        <h2>Edit Album</h2>
        <form onSubmit={handleSubmit}>
          <div className="input-group">
            <label htmlFor="directory-name">Album Name</label>
            <input
              type="text"
              id="directory-name"
              value={directoryName}
              onChange={(e) => setDirectoryName(e.target.value)}
            />
          </div>
          <div className="input-group">
            <label htmlFor="directory-position">Album Position</label>
            <input
              type="number"
              id="directory-position"
              value={directoryPosition}
              onChange={(e) =>
                setDirectoryPosition(parseInt(e.target.value, 10))
              }
            />
          </div>
          <div className="button-group">
            <button type="submit" className="submit-button">
              Save Changes
            </button>
            <button
              type="button"
              className="delete-button"
              onClick={handleDelete}
            >
              Delete Album
            </button>
          </div>
        </form>
      </div>
      {showConfirmDeleteModal && (
        <ConfirmDeleteModal
          onClose={() => setShowConfirmDeleteModal(false)}
          onConfirm={confirmDelete}
        />
      )}
    </div>
  );
};

export default EditAlbumPopup;

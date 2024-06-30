import React from "react";
import "./ConfirmDeleteModal.css";

const ConfirmDeleteModal = ({ onClose, onConfirm }) => {
  return (
    <div className="confirm-delete-modal-overlay" onClick={onClose}>
      <div className="confirm-delete-modal" onClick={(e) => e.stopPropagation()}>
        <h2>Delete Album Confirmation</h2>
        <p>
          Are you sure you want to delete this album? This action will delete
          all sub-albums and their images as well.
        </p>
        <div className="button-group">
          <button className="cancel-button" onClick={onClose}>
            Cancel
          </button>
          <button className="confirm-button" onClick={onConfirm}>
            Delete
          </button>
        </div>
      </div>
    </div>
  );
};

export default ConfirmDeleteModal;

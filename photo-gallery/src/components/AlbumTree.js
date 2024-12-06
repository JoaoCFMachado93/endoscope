import React, { useState, useEffect, useRef } from "react";
import { Link } from "react-router-dom"; // Import Link from React Router
import "./AlbumTree.css";
import AddImagePopup from "./AddImagePopup";
import EditAlbumPopup from "./EditAlbumPopup";
import { useAuth } from "./AuthProvider";
import {
  createParentDirectory,
  createSubDirectory,
} from "../services/DirectoryService";
import { backendBaseUrl } from "../config";

const AlbumTree = ({ albums, onSelectAlbum, onImageAdded }) => {
  const [selectedAlbum, setSelectedAlbum] = useState(null);
  const [subAlbums, setSubAlbums] = useState({});
  const [showAddImagePopup, setShowAddImagePopup] = useState(false);
  const [showEditAlbumPopup, setShowEditAlbumPopup] = useState(null);
  const [currentAlbumId, setCurrentAlbumId] = useState(null);
  const [showDropdownForAlbum, setShowDropdownForAlbum] = useState(null);
  const { getUser } = useAuth();
  const dropdownRef = useRef(null);

  const user = getUser();
  const isAdmin = user && user.role.toUpperCase() === "ADMIN";

  useEffect(() => {
    const handleClickOutside = (event) => {
      if (dropdownRef.current && !dropdownRef.current.contains(event.target)) {
        if (!event.target.closest(".dropdown-menu")) {
          setShowDropdownForAlbum(null);
        }
      }
    };

    document.addEventListener("mousedown", handleClickOutside);
    return () => {
      document.removeEventListener("mousedown", handleClickOutside);
    };
  }, []);

  const handleAlbumClick = async (album) => {
    setSelectedAlbum(album);
    onSelectAlbum(album);

    if (subAlbums[album.directoryId]) {
      setSubAlbums((prevState) => ({
        ...prevState,
        [album.directoryId]: null,
      }));
    } else {
      try {
        if (!user) {
          throw new Error("User not logged in");
        }

        const response = await fetch(
          `${backendBaseUrl}/directories/subDirectories/${album.directoryId}`,
          {
            headers: {
              Authorization: `Bearer ${user.token}`,
            },
          }
        );

        const data = await response.json();
        setSubAlbums((prevState) => ({
          ...prevState,
          [album.directoryId]: data,
        }));
      } catch (error) {
        console.error("Error fetching subdirectories:", error);
      }
    }
  };

  const handleAddImageButtonClick = (albumId) => {
    setCurrentAlbumId(albumId);
    setShowAddImagePopup(true);
    setShowDropdownForAlbum(null);
  };

  const handleEditAlbumButtonClick = (album) => {
    setCurrentAlbumId(album.directoryId);
    setShowEditAlbumPopup(album);
    setShowDropdownForAlbum(null);
  };

  const handleCreateParentDirectory = async () => {
    const user = getUser();

    const directoryName = prompt("Enter the name of the new parent directory:");
    if (!directoryName) {
      return;
    }

    const success = await createParentDirectory(directoryName, user.token);
    if (success) {
      window.location.reload();
    } else {
      alert("Failed to create parent directory. Please try again.");
    }
  };

  const handleCreateSubDirectory = async (parentDirectoryId) => {
    const user = getUser();

    const directoryName = prompt("Enter the name of the new sub-directory:");
    if (!directoryName) {
      setShowDropdownForAlbum(null);
      return;
    }

    try {
      const updatedData = await createSubDirectory(
        parentDirectoryId,
        directoryName,
        user.token
      );
      if (updatedData) {
        const response = await fetch(
          `${backendBaseUrl}/directories/subDirectories/${parentDirectoryId}`,
          {
            headers: {
              Authorization: `Bearer ${user.token}`,
            },
          }
        );
        if (!response.ok) {
          throw new Error("Failed to fetch sub-directories");
        }
        const data = await response.json();
        setSubAlbums((prevState) => ({
          ...prevState,
          [parentDirectoryId]: data,
        }));
      } else {
        throw new Error("Failed to create sub-directory");
      }
    } catch (error) {
      console.error("Error creating sub-directory:", error);
      alert("Failed to create sub-directory. Please try again.");
    }

    setShowDropdownForAlbum(null);
  };

  const toggleDropdown = (albumId, e) => {
    e.stopPropagation();
    setShowDropdownForAlbum((prevAlbumId) =>
      prevAlbumId === albumId ? null : albumId
    );
  };

  const renderDropdown = (album) => {
    return (
      <div className="dropdown" ref={dropdownRef}>
        {isAdmin && (
          <button
            className="dropdown-toggle"
            type="button"
            onClick={(e) => toggleDropdown(album.directoryId, e)}
          >
            ...
          </button>
        )}
        {showDropdownForAlbum === album.directoryId && (
          <div className="dropdown-menu">
            <button
              className="dropdown-item"
              onClick={() => handleAddImageButtonClick(album.directoryId)}
            >
              Add Image
            </button>
            <button
              className="dropdown-item"
              onClick={() => handleEditAlbumButtonClick(album)}
            >
              Edit Album
            </button>
            <button
              className="dropdown-item"
              onClick={() => handleCreateSubDirectory(album.directoryId)}
            >
              Create Sub-directory
            </button>
          </div>
        )}
      </div>
    );
  };

  const renderAlbums = (albums) => {
    // Sort albums by directoryPosition ascending
    albums.sort((a, b) => a.directoryPosition - b.directoryPosition);

    return albums.map((album) => (
      <li key={album.directoryId}>
        <div
          className={`album ${selectedAlbum === album ? "selected" : ""}`}
          onClick={() => handleAlbumClick(album)}
        >
          <span>{album.directoryName}</span>
          {album.imageCount > 0 && (
            <span className="image-count-bubble">{album.imageCount}</span>
          )}
          {renderDropdown(album)}
        </div>
        {subAlbums[album.directoryId] &&
          subAlbums[album.directoryId].length > 0 && (
            <ul className="sub-albums">
              {renderAlbums(subAlbums[album.directoryId])}
            </ul>
          )}
      </li>
    ));
  };

  return (
    <div className="album-tree">
      {isAdmin && (
        <button
          className="create-directory-button"
          onClick={handleCreateParentDirectory}
        >
          Create New Album
        </button>
      )}
      <div className="about-links-container">
        <Link to="/about-endoscope" className="about-link">
          About ScopeView
        </Link>
        <Link to="/contributors" className="about-link">
          Contributors
        </Link>
        <Link to="/contributions" className="about-link">
        How to Contribute
        </Link>
      </div>
      <ul>{renderAlbums(albums)}</ul>
      {showAddImagePopup && (
        <AddImagePopup
          directoryId={currentAlbumId}
          onClose={() => {
            setShowAddImagePopup(false);
            onImageAdded();
          }}
        />
      )}
      {showEditAlbumPopup && (
        <EditAlbumPopup
          album={showEditAlbumPopup}
          onClose={() => setShowEditAlbumPopup(null)}
          onAlbumUpdated={() => window.location.reload()}
          onAlbumDeleted={() => window.location.reload()}
        />
      )}
    </div>
  );
};

export default AlbumTree;

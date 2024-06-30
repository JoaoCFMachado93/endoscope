import React, { useState } from "react";
import DirectoryContainer from "./DirectoryContainer";
import ImageContainer from "./ImageContainer";
import { useAuth } from "./AuthProvider";
import { backendBaseUrl } from "../config";
import "./Home.css";

const Home = () => {
  const { getUser, userLogout } = useAuth();
  const [selectedAlbum, setSelectedAlbum] = useState(null);
  const [images, setImages] = useState([]);
  const [imageContainerKey, setImageContainerKey] = useState(0);
  const [directoryDescription, setDirectoryDescription] = useState("");

  const user = getUser();

  const handleSelectAlbum = (album, description) => {
    setSelectedAlbum(album);
    setDirectoryDescription(description);
    console.log("Selected album:", album);
    console.log("Directory description:", description);
  };

  const handleLogout = () => {
    userLogout();
  };

  const handleImageAdded = async () => {
    if (selectedAlbum) {
      try {
        const response = await fetch(
          `${backendBaseUrl}/images/directory/${selectedAlbum.directoryId}`,
          {
            headers: {
              Authorization: `Bearer ${user.token}`,
            },
          }
        );
        if (!response.ok) {
          throw new Error("Failed to fetch images");
        }
        const data = await response.json();
        setImages(data);
        setImageContainerKey((prevKey) => prevKey + 1);
      } catch (error) {
        console.error("Error fetching images:", error);
      }
    }
  };

  return (
    <div className="app">
      <div className="header">
        <div className="logo">
          <h1 className="logo-main">EndoScope</h1>
          <p className="logo-sub">Atlas of Gastrointestinal Endoscopy</p>
        </div>
        <nav className="navbar">
          <div className="navbar-right">
            <button className="search-button">Search</button>
            <input
              type="text"
              placeholder="Search..."
              className="search-input"
            />
            <button className="profile-button" onClick={handleLogout}>
              Logout
            </button>
          </div>
        </nav>
      </div>
      <div className="content">
        <div className="album-container">
          <DirectoryContainer
            onSelectAlbum={handleSelectAlbum}
            onImageAdded={handleImageAdded}
          />
        </div>
        <ImageContainer
          key={imageContainerKey}
          images={images}
          selectedAlbum={selectedAlbum}
          directoryDescription={directoryDescription}
        />
      </div>
    </div>
  );
};

export default Home;

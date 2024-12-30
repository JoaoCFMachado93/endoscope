import React from "react";
import { Link } from "react-router-dom";
import "./Contributions.css";
import sped_logo from "../assets/sped.png"; // Update with your SPED logo path

const Contributions = () => {
  const contactEmail = "luis.correia.gomes20@gmail.com"; // Update with the actual email

  return (
    <div className="contributions">
      <h1>Contribute to ScopeView</h1>

      <div className="contributions-text">
        <h2>Why Contribute?</h2>
        <p>
          ScopeView is a project designed for the endoscopic community, with the goal of growing and evolving through its engagement. To contribute, please submit your images with the following details: caption, indication of histological confirmation (when applicable), clinical name, and hospital of the submitter.
        </p>

        <h2>How Can You Contribute?</h2>
        <ul>
          <li>Share your endoscopic images or case studies.</li>
          <li>Report bugs or suggest improvements for the platform.</li>
          <li>
            <strong>Contribute directly to albums:</strong> Click the "Contribute" button on any album to add your images. This will create a <strong>pending request</strong> that an administrator will review. You will be notified by email when your image is either approved or denied.
          </li>
        </ul>

        <h2>Get in Touch</h2>
        <div className="get-in-touch">
          <p>
            If you're interested in contributing, we'd love to hear from you! Please send us your endoscopic images along with the following details:
          </p>
          <ul>
            <li>A brief description or caption for the image.</li>
            <li>The clinical name or case title.</li>
            <li>The name of the hospital where the image was taken.</li>
          </ul>
          <p>
            Send your submissions to:{" "}
            <a href={`mailto:${contactEmail}`} className="email-link">{contactEmail}</a>.
          </p>
          <p>
            Together, we can improve GI endoscopy and advance the field.
          </p>
        </div>
      </div>

      <div className="back-button-container">
        <Link to="/" className="back-button">
          Go Back to Home
        </Link>
      </div>
      <img src={sped_logo} alt="SPED Logo" className="logo-at-bottom-right" />
    </div>
  );
};

export default Contributions;

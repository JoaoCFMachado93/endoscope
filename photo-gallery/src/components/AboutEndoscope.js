import React from "react";
import { Link } from "react-router-dom";
import "./AboutEndoscope.css";
import endoscope_logo from "../assets/logo.png; // Update with your actual logo path
import sped_logo from "../assets/sped.png"; // Update with your sped.png logo path

const AboutEndoscope = () => {
  return (
    <div className="about-endoscope">
      <h1></h1>
      <div className="logo">
        <img src={endoscope_logo} alt="EndoScope Logo" className="logo-img" />
      </div>
      <h1></h1>

      <div className="about-text">
        <h1>Welcome to our Endoscopy Atlas</h1>
        <p>
          A platform dedicated to the gastroenterology community, providing a comprehensive collection of images accompanied by descriptive texts. This atlas serves as a valuable resource for physicians, offering a user-friendly way to enhance their learning and expertise in the field. The images in this atlas are derived from real cases encountered in clinical practice, ensuring relevance and practical applicability.
        </p>
        <p>
          We believe in the power of community collaboration and invite everyone to contribute by sharing their own endoscopic images and cases. One of the core objectives of our atlas is to improve the practice of GI endoscopy by fostering a collaborative learning environment. We believe that collective knowledge and shared experiences are essential for advancing the field. Therefore, we invite all members of the gastroenterology community to contribute to this growing repository. By submitting your own endoscopic images and case studies, you can help create a diverse and rich educational resource that benefits everyone.
        </p>
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

export default AboutEndoscope;

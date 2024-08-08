import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "./AuthProvider";
import { FaEnvelope, FaLock } from "react-icons/fa"; // Import icons from react-icons library
import "./LoginForm.css"; // Import custom CSS for the login form
import { backendBaseUrl } from "../config";

const LoginForm = () => {
  const { userLogin } = useAuth();
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    email: "",
    password: "",
  });
  const [isError, setIsError] = useState(false);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const { email, password } = formData;
    if (!email || !password) {
      setIsError(true);
      return;
    }
    try {
      const response = await fetch(`${backendBaseUrl}/auth/login`, {
        referrerPolicy: "unsafe-url",
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      });

      if (!response.ok) {
        throw new Error("Login failed");
      }

      const userData = await response.json();
      userLogin(userData);
      navigate("/");
    } catch (error) {
      console.error("Login failed:", error);
      setIsError(true);
    }
  };

  const handleRegister = () => {
    navigate("/register"); // Navigate to the registration form
  };

  return (
    <div className="login-form-container">
      <div className="login-card">
        <h2>Login</h2>
        <form onSubmit={handleSubmit}>
          <div className="input-group">
            <FaEnvelope className="input-icon" />
            <input
              type="text"
              name="email"
              value={formData.email}
              onChange={handleChange}
              placeholder="Email"
              required
            />
          </div>
          <div className="input-group">
            <FaLock className="input-icon" />
            <input
              type="password"
              name="password"
              value={formData.password}
              onChange={handleChange}
              placeholder="Password"
              required
            />
          </div>
          <button className="login-form-button">Login</button>
        </form>
        {isError && (
          <p>Error: Unable to login. Please check your credentials.</p>
        )}
        <div className="register-message">
          <p>
            Don't have an account?{" "}
            <button onClick={handleRegister}>Register</button>
          </p>
        </div>
      </div>
    </div>
  );
};

export default LoginForm;

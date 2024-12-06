import React from "react";
import { BrowserRouter as Router, Route, Routes, Navigate } from "react-router-dom";
import { useAuth } from "./components/AuthProvider";
import Home from "./components/Home";
import LoginForm from "./components/LoginForm";
import RegisterForm from "./components/RegisterForm";
import AboutEndoscope from "./components/AboutEndoscope";
import Contributors from "./components/Contributors";
import Contributions from "./components/Contributions";

const AppRoutes = () => {
  const { userIsAuthenticated } = useAuth();

  return (
    <Router>
      <Routes>
        <Route
          path="/"
          element={
            userIsAuthenticated() ? (
              <Home />
            ) : (
              <Navigate to="/login" replace={true} />
            )
          }
        />
        <Route path="/login" element={<LoginForm />} />
        <Route path="/register" element={<RegisterForm />} />
        <Route path="/about-endoscope" element={<AboutEndoscope />} />
        <Route path="/contributors" element={<Contributors />} />
        <Route path="/contributions" element={<Contributions />} />

      </Routes>
    </Router>
  );
};

export default AppRoutes;

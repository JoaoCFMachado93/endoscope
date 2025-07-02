import React, { useEffect } from "react";

const App = () => {
  useEffect(() => {
    // Redirect after 3 seconds
    const timer = setTimeout(() => {
      window.location.href = "https://scopeviewapp.duckdns.org";
    }, 3000);

    return () => clearTimeout(timer);
  }, []);

  return (
    <div
      style={{
        height: "100vh",
        backgroundColor: "#f0f4f8",
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
        flexDirection: "column",
        fontFamily: "'Segoe UI', Tahoma, Geneva, Verdana, sans-serif",
        color: "#1a202c",
        textAlign: "center",
        padding: "0 20px"
      }}
    >
      <div
        style={{
          backgroundColor: "#ffffff",
          padding: "40px",
          borderRadius: "12px",
          boxShadow: "0 8px 24px rgba(0, 0, 0, 0.1)",
          maxWidth: "500px",
          width: "100%"
        }}
      >
        <h1 style={{ fontSize: "1.8rem", marginBottom: "20px" }}>
          🌐 We’ve Moved!
        </h1>
        <p style={{ fontSize: "1rem", marginBottom: "20px", lineHeight: "1.6" }}>
          Our website has a new home. You’ll be redirected automatically in a few seconds.
          If not, click the button below to visit us manually.
        </p>
        <a
          href="https://scopeviewapp.duckdns.org"
          style={{
            backgroundColor: "#2563eb",
            color: "#fff",
            padding: "12px 24px",
            borderRadius: "8px",
            textDecoration: "none",
            fontWeight: "bold",
            transition: "background-color 0.3s ease"
          }}
          onMouseOver={(e) => (e.target.style.backgroundColor = "#1e40af")}
          onMouseOut={(e) => (e.target.style.backgroundColor = "#2563eb")}
        >
          Go to New Site
        </a>
      </div>
    </div>
  );
};

export default App;

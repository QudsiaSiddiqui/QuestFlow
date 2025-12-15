import { useState } from "react";
import axios from "axios";

function Register({ onLogin, setPage }) {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const register = async () => {
    if (!username || !password) {
      alert("Please enter both username and password");
      return;
    }

    try {
      const res = await axios.post("http://localhost:8080/auth/register", {
        username,
        password,
      });

      alert("Registered successfully!");
      if (onLogin) onLogin(res.data); // Auto-login
    } catch (err) {
      console.error("Error registering user:", err.response?.data || err.message);
      alert("Registration failed! " + (err.response?.data || err.message));
    }
  };

  return (
    <div className="card">
      <h3>Register</h3>

      <input
        placeholder="Username"
        value={username}
        onChange={(e) => setUsername(e.target.value)}
      />
      <input
        type="password"
        placeholder="Password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />

      <button onClick={register}>Register</button>

      <button onClick={() => setPage("login")} className="switch-btn">
        Already have an account? Login
      </button>
    </div>
  );
}

export default Register;

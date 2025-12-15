import { useState } from "react";
import axios from "axios";

function Login({ onLogin, setPage }) {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const login = async () => {
    if (!username || !password) {
      alert("Please enter both username and password");
      return;
    }

    try {
      const res = await axios.post("http://localhost:8080/auth/login", {
        username,
        password,
      });

      if (onLogin) onLogin(res.data);
    } catch (err) {
      console.error("Login failed:", err.response?.data || err.message);
      alert("Login failed! " + (err.response?.data || err.message));
    }
  };

  return (
    <div className="card">
      <h3>Login</h3>

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

      <button onClick={login}>Login</button>

      <button onClick={() => setPage("register")} className="switch-btn">
        Don't have an account? Register
      </button>
    </div>
  );
}

export default Login;

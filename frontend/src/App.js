import { useState } from "react";
import "./App.css";
import Register from "./Register";
import Login from "./Login";
import Profile from "./Profile";
import Task from "./Task";
import axios from "axios";

function App() {
  const [page, setPage] = useState("register");
  const [user, setUser] = useState(null);
  const [stats, setStats] = useState(null);
  const [darkMode, setDarkMode] = useState(false);

  const fetchStats = async (userId) => {
    try {
      const res = await axios.get(`http://localhost:8080/user/stats/${userId}`);
      setStats(res.data);
    } catch (err) {
      console.error("Error fetching stats:", err.response?.data || err.message);
    }
  };

  const onLogin = (userData) => {
    setUser(userData);
    fetchStats(userData.id);
    setPage("dashboard");
  };

  return (
    <div className={darkMode ? "app dark" : "app"}>
      {/* Small toggle at top-right */}
      <button className="toggle-btn" onClick={() => setDarkMode(!darkMode)}>
        {darkMode ? "☀️" : "🌙"}
      </button>

      {page === "register" && <Register onLogin={onLogin} setPage={setPage} />}
      {page === "login" && <Login onLogin={onLogin} setPage={setPage} />}

      {page === "dashboard" && user && stats && (
        <div className="dashboard">
          <Profile user={user} stats={stats} />
          <Task user={user} refreshStats={() => fetchStats(user.id)} />
        </div>
      )}
    </div>
  );
}

export default App;

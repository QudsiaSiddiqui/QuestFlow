import { useEffect, useState } from "react";
import axios from "axios";

function Task({ user, refreshStats }) {
  const [tasks, setTasks] = useState([]);
  const [title, setTitle] = useState("");

  const fetchTasks = async () => {
    try {
      const res = await axios.get(`http://localhost:8080/task/all/${user.id}`);
      setTasks(res.data);
    } catch (err) {
      console.error(err);
    }
  };

  useEffect(() => {
    fetchTasks();
  }, []);

  const addTask = async () => {
    if (!title) return;
    try {
      await axios.post("http://localhost:8080/task/create", {
        title,
        xpReward: 20,
        user: { id: user.id }
      });
      setTitle("");
      fetchTasks();
    } catch (err) {
      console.error(err);
    }
  };

  const completeTask = async (id) => {
    try {
      await axios.post(`http://localhost:8080/task/complete/${id}`);
      fetchTasks();
      refreshStats(user.id);
    } catch (err) {
      console.error(err);
    }
  };

  return (
    <div className="task-card">
      <h3>📝 Tasks</h3>
      <div className="task-input">
        <input
          placeholder="New task..."
          value={title}
          onChange={(e) => setTitle(e.target.value)}
        />
        <button onClick={addTask}>Add</button>
      </div>

      {tasks.map((task) => (
        <div key={task.id} className="task-row">
          <span>{task.title}</span>
          {!task.completed && (
            <button className="check-btn" onClick={() => completeTask(task.id)}>
              ✓
            </button>
          )}
        </div>
      ))}
    </div>
  );
}

export default Task;

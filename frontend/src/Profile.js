function Profile({ user, stats }) {
  if (!stats) return null;

  return (
    <div className="profile-header">
  <div className="profile-name">{user.username}</div>
  <div className="profile-stats">
    <p>Level {stats.level}</p>
    <p>XP: {stats.xp} / {stats.xpForNextLevel}</p>
    <div className="progress-bar">
      <div className="progress-fill" style={{ width: `${stats.progress}%` }}></div>
    </div>
  </div>
</div>

  );
}

export default Profile;

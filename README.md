# QuestFlow

QuestFlow is a full-stack, gamified task management application designed to make productivity engaging and rewarding.

Users can create tasks, complete them to earn XP, and track their progress visually through levels and progress bars.

---

## Features

### User Authentication
- Register and login functionality
- Session-based authentication flow

### Task Management
- Create new tasks
- View all tasks associated with a user
- Complete tasks to earn XP

### Gamification
- XP-based leveling system
- Progress bar showing XP toward the next level
- Instant stat updates after task completion

### User Interface
- Built with React
- Light and dark mode toggle
- Clean, centered, modern layout

---

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring MVC
- Spring Data JPA

### Frontend
- React
- Axios
- CSS

### Database
- H2 (easily replaceable with MySQL or PostgreSQL)

### Build Tools
- Maven
- npm

---

### Project Structure

### Backend

- controller – REST APIs for authentication, users, and tasks

- service – business logic for XP, leveling, and task handling

- repository – database access using JPA

- entity – User and Task models

### Frontend

- App.js – application state and navigation

- Profile.js – user details and XP progress

- Task.js – task creation and completion

- Login.js / Register.js – authentication screens

- App.css – styling and theme management

### Application Flow

- User registers or logs in

- User creates tasks

- Completing a task rewards XP

- XP updates level and progress bar

- UI updates instantly to reflect changes


package com.QuestFlow.QuestFlow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private int xpReward;

    private boolean completed = false;

    // Many tasks belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // --- Constructors ---
    public Task() {}

    public Task(Long id, String title, String description, int xpReward, boolean completed, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.xpReward = xpReward;
        this.completed = completed;
        this.user = user;
    }

    // --- Getters / Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getXpReward() { return xpReward; }
    public void setXpReward(int xpReward) { this.xpReward = xpReward; }

    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", xpReward=" + xpReward +
                ", completed=" + completed +
                '}';
    }
}

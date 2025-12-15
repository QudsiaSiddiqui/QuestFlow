package com.QuestFlow.QuestFlow.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    private String password;

    private int xp = 0;
    private int level = 1;
    private int streak = 0;
    private LocalDate lastActiveDate;


    // --- Constructors ---
    public User() {}

    public User(Long id, String username, String password, int xp, int level,int streak,LocalDate lastActivceDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.xp = xp;
        this.level = level;
        this.streak=streak;
        this.lastActiveDate=lastActivceDate;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public int getXp() { return xp; }
    public void setXp(int xp) { this.xp = xp; }

    public int getLevel() { return level; }
    public void setLevel(int level) { this.level = level; }

    public int getStreak(){ return streak;}
    public void setStreak(int streak) {this.streak=streak;}

    public LocalDate getLastActiveDate(){return lastActiveDate;}
    public void setLastActiveDate(LocalDate lastActiveDate){ this.lastActiveDate=lastActiveDate;}
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", xp=" + xp +
                ", level=" + level +
                '}';
    }
}

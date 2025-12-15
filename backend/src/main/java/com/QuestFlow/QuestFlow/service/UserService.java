package com.QuestFlow.QuestFlow.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.QuestFlow.QuestFlow.entity.User;
import com.QuestFlow.QuestFlow.repository.UserRepository;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    public UserService(UserRepository repo) {
        this.userRepository = repo;
    }

    @Override
    public User registerUser(String username, String password) {
        User existing = userRepository.findByUsername(username);
        if (existing != null) {
            throw new RuntimeException("Username already exists!");
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setXp(0);
        user.setLevel(1);

        return userRepository.save(user);
    }
     @Override
    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);

        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid username or password!");
        }

        return user;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public User getUserProfile(Long id) {
    return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
}
    @Override
    public int xpForNextLevel(int level) {
        return level * level * 100;
    }
    @Override
    public void rewardXp(Long userId, int xpEarned) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        int xp = user.getXp() + xpEarned;

        while (xp >= xpForNextLevel(user.getLevel())) {
            xp -= xpForNextLevel(user.getLevel());
            user.setLevel(user.getLevel() + 1);
        }

        user.setXp(xp);

        LocalDate today = LocalDate.now();

        if (user.getLastActiveDate() == null) {
            user.setStreak(1);
        } else if (user.getLastActiveDate().plusDays(1).equals(today)) {
            user.setStreak(user.getStreak() + 1);
        } else if (!user.getLastActiveDate().equals(today)) {
            user.setStreak(1);
        }

        user.setLastActiveDate(today);

        userRepository.save(user);
    }
    @Override
public Map<String, Object> getUserStats(Long userId) {
    User user = getUserById(userId);

    int level = user.getLevel();
    int xp = user.getXp();
    int streak = user.getStreak();

    int xpForNextLevel = xpForNextLevel(level);
    double progress = (double) xp / xpForNextLevel * 100;

    Map<String, Object> stats = new HashMap<>();
    stats.put("level", level);
    stats.put("xp", xp);
    stats.put("streak", streak);
    stats.put("xpForNextLevel", xpForNextLevel);
    stats.put("progress", progress);

    return stats;
}

}

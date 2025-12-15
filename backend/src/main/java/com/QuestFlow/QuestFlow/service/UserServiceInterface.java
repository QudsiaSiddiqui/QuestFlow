package com.QuestFlow.QuestFlow.service;


import java.util.Map;

import com.QuestFlow.QuestFlow.entity.User;
public interface UserServiceInterface {
User registerUser(String username, String password);
    User loginUser(String username, String password);
    User getUserById(Long id);
    User saveUser(User user);
    User getUserProfile(Long id);
    int xpForNextLevel(int level);
    void rewardXp(Long userId, int xpEarned);
    Map<String, Object> getUserStats(Long userId);
}

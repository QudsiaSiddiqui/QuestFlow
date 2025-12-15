package com.QuestFlow.QuestFlow.dto;

public class UserStatsResponse {

    private int level;
    private int xp;
    private int streak;

    public UserStatsResponse(int level, int xp, int streak) {
        this.level = level;
        this.xp = xp;
        this.streak = streak;
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public int getStreak() {
        return streak;
    }
}

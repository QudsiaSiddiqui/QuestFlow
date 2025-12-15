package com.QuestFlow.QuestFlow.service;
import java.util.List;

import com.QuestFlow.QuestFlow.entity.Task;
import com.QuestFlow.QuestFlow.entity.User;
public interface TaskServiceInterface {
    Task createTask(User user, String title, int xpReward);
    List<Task> getTasks(User user);
    Task completeTask(Long taskId);
}

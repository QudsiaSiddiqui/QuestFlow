package com.QuestFlow.QuestFlow.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.QuestFlow.QuestFlow.entity.Task;
import com.QuestFlow.QuestFlow.entity.User;
import com.QuestFlow.QuestFlow.repository.TaskRepository;

@Service
public class TaskService implements TaskServiceInterface {

    private final TaskRepository taskRepo;
    private final UserService userService;

    public TaskService(TaskRepository repo, UserService userService) {
        this.taskRepo = repo;
        this.userService = userService;
    }

    @Override
    public Task createTask(User user, String title, int xpReward) {
        Task task = new Task();
        task.setUser(user);
        task.setTitle(title);
        task.setCompleted(false);
        task.setXpReward(xpReward);

        return taskRepo.save(task);
    }

    @Override
    public List<Task> getTasks(User user) {
        return taskRepo.findByUser(user);
    }
    @Override
    public Task completeTask(Long taskId) {
        Task task = taskRepo.findById(taskId)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        if (task.isCompleted()) {
            return task;
        }

        task.setCompleted(true);
        taskRepo.save(task);

        userService.rewardXp(task.getUser().getId(), task.getXpReward());

        return task;
    }

}

package com.QuestFlow.QuestFlow.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.QuestFlow.QuestFlow.entity.Task;
import com.QuestFlow.QuestFlow.entity.User;
import com.QuestFlow.QuestFlow.service.TaskService;
import com.QuestFlow.QuestFlow.service.UserService;

@RestController
@RequestMapping("/task")
@CrossOrigin("*")
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }

    @PostMapping("/create")
    public Task createTask(@RequestBody Task task) {

        User user = userService.getUserById(task.getUser().getId());
        return taskService.createTask(user, task.getTitle(), task.getXpReward());
    }

    @GetMapping("/all/{userId}")
    public List<Task> getTasks(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return taskService.getTasks(user);
    }

    @PostMapping("/complete/{taskId}")
    public Task completeTask(@PathVariable Long taskId) {
        return taskService.completeTask(taskId);
    }
}

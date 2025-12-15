package com.QuestFlow.QuestFlow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.QuestFlow.QuestFlow.entity.Task;
import com.QuestFlow.QuestFlow.entity.User;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);

}

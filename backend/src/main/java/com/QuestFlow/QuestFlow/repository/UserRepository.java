package com.QuestFlow.QuestFlow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.QuestFlow.QuestFlow.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query: find user by username
    User findByUsername(String username);
}

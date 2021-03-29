package com.topal.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.topal.application.userdetails.User;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUsername(String username);
}
package com.example.springjpamultiple.security.repositories;

import com.example.springjpamultiple.security.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
}

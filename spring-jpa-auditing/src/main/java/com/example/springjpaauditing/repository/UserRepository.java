package com.example.springjpaauditing.repository;

import com.example.springjpaauditing.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Long>{
    
}

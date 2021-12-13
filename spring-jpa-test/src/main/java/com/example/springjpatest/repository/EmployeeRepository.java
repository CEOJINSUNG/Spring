package com.example.springjpatest.repository;

import com.example.springjpatest.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    Employee findByFirstName(String username);

}

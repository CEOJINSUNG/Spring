package com.example.springjpatest;

import com.example.springjpatest.model.Employee;

import com.example.springjpatest.repository.EmployeeRepository;

import static org.hamcrest.core.IsEqual.equalToObject;
import static org.hamcrest.core.IsNull.notNullValue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class EmployRepositoryTests {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSaveEmployee() {

        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
        employeeRepository.save(employee);
        Employee employee2 = employeeRepository.findByFirstName("admin");

        notNullValue(employee);
        equalToObject(employee2.getFirstName(), employee.getFirstName());
        equalToObject(employee2.getLastName(), employee.getLastName());
        
    }
}

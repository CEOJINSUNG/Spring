package com.example.springjpatest;

import com.example.springjpatest.model.Employee;

import com.example.springjpatest.repository.EmployeeRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EmployRepositoryTests {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testSaveEmployee() {

        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
        employeeRepository.save(employee);
        Employee employee2 = employeeRepository.findByFirstName("admin");

        assertNotNull(employee);
        assertEquals(employee2.getFirstName(), employee.getFirstName());
        assertEquals(employee2.getLastName(), employee.getLastName());
        
    }

    @Test
    public void testGetEmployee() {

        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
        employeeRepository.save(employee);
        Employee employee2 = employeeRepository.findByFirstName("admin");
        assertNotNull(employee);
        assertEquals(employee2.getFirstName(), employee.getFirstName());
        assertEquals(employee2.getLastName(), employee.getLastName());
    }

    @Test
    public void testDeleteEmployee() {
        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
        employeeRepository.save(employee);
        employeeRepository.delete(employee);
    }

    @Test
    public void findAllEmployees() {
        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
        employeeRepository.save(employee);
        assertNotNull(employeeRepository.findAll());
    }

    @Test
    public void deleteByEmployeeIdTest() {
        Employee employee = new Employee("admin", "admin", "admin@gmail.com");
        Employee emp = employeeRepository.save(employee);
        employeeRepository.deleteById(emp.getId());
    }
    
}

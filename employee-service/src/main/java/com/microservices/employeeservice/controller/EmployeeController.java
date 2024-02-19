package com.microservices.employeeservice.controller;

import com.microservices.employeeservice.model.Employee;
import com.microservices.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee addDepartment(@RequestBody Employee employee) {
        LOGGER.info("Added Employee: {}", employee);
        return employeeRepository.addDepartment(employee);
    }

    @GetMapping
    public List<Employee> findAll() {
        LOGGER.info("Employee findAll()");
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        LOGGER.info("Employee findAll(id) - ", id);
        return employeeRepository.findById(id);
    }

    @GetMapping("/department/{departmentId}")
    public List<Employee> findByDepartment(@PathVariable Long departmentId) {
        LOGGER.info("Employee findByDepartment(departmentId) - ", departmentId);
        return employeeRepository.findByDepartment(departmentId);
    }

}

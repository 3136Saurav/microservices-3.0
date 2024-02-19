package com.microservices.employeeservice.repository;

import com.microservices.employeeservice.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EmployeeRepository {

    private List<Employee> employeeList = new ArrayList<>();

    public Employee addDepartment(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    public Employee findById(Long id) {
        return employeeList.stream().filter(employee -> employee.id().equals(id)).findFirst().orElseThrow();
    }

    public List<Employee> findAll() {
        return employeeList;
    }

    public List<Employee> findByDepartment(Long departmentId) {
        return employeeList.stream().filter(employee -> employee.departmentId().equals(departmentId)).collect(Collectors.toList());
    }
}

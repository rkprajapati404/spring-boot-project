package com.demo.service;

import com.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee saveEmployee(Employee employee);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);

    Employee findById(Long id);

    List<Employee> findAllEmployee();

}

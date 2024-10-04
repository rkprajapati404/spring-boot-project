package com.demo.controller;


import com.demo.entity.Employee;
import com.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        ResponseEntity<Employee> response = null;
        Employee employee1 = employeeService.saveEmployee(employee);
        if (employee1 != null) {
            response = ResponseEntity.status(201).body(employee1);
        }
        return response;
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        ResponseEntity<Employee> response = null;
        Employee employee1 = employeeService.updateEmployee(employee);
        if (employee1 != null) {
            response = ResponseEntity.status(200).body(employee1);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        ResponseEntity<Employee> response = null;
        Employee employee1 = employeeService.findById(id);
        if (employee1 != null) {
            response = ResponseEntity.status(200).body(employee1);
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        ResponseEntity<Employee> response = null;
        List<Employee> allEmployee = employeeService.findAllEmployee();
        return ResponseEntity.status(200).body(allEmployee);
    }


}

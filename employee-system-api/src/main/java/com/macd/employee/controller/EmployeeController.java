package com.macd.employee.controller;

import com.macd.employee.model.Employee;
import com.macd.employee.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeServiceImpl service;

    public EmployeeController(EmployeeServiceImpl service) {
        this.service = service;
    }

    @PostMapping("/employees/save")
    public Employee createEmployee(@RequestBody Employee employee){
        return service.createEmployee(employee);
    }

    @GetMapping("/employees/all")
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }
}

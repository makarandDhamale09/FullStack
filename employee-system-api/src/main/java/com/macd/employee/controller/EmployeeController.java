package com.macd.employee.controller;

import com.macd.employee.model.Employee;
import com.macd.employee.service.EmployeeServiceImpl;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

  private final EmployeeServiceImpl service;

  public EmployeeController(EmployeeServiceImpl service) {
    this.service = service;
  }

  @PostMapping("/employees/save")
  public Employee createEmployee(@RequestBody Employee employee) {
    return service.createEmployee(employee);
  }

  @GetMapping("/employees/all")
  public List<Employee> getAllEmployees() {
    return service.getAllEmployees();
  }

  @DeleteMapping("/employees/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) {
    boolean deleted = false;
    deleted = service.deleteEmployee(id);
    Map<String, Boolean> response = Map.of("deleted", deleted);
    return ResponseEntity.ok(response);
  }
}

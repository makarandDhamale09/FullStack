package com.macd.employee.service;

import com.macd.employee.model.Employee;
import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    boolean deleteEmployee(Long id);

    Employee getEmployeeById(Long id);

    boolean updateEmployee(Employee employee);
}

package com.macd.employee.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import com.macd.employee.entity.EmployeeEntity;
import com.macd.employee.model.Employee;
import com.macd.employee.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

  @InjectMocks EmployeeServiceImpl employeeService;

  @Mock EmployeeRepository employeeRepository;

  @BeforeEach
  void setup() {
    ReflectionTestUtils.setField(employeeService, "empId", 1L);
  }

  @Test
  void createEmployee() {
    when(employeeRepository.save(any())).thenReturn(any());
    employeeService.createEmployee(getEmployee());
    verify(employeeRepository, times(1)).save(any());
  }

  private Employee getEmployee() {
    return new Employee(1L, "Jane", "Doe", "jane@gmail.com");
  }

  @Test
  void getAllEmployees() {
    when(employeeRepository.findAll()).thenReturn(getEmployees(2));
    List<Employee> allEmployees = employeeService.getAllEmployees();
    Assertions.assertEquals(2, allEmployees.size());
  }

  private List<EmployeeEntity> getEmployees(int size) {
    List<EmployeeEntity> employees = new ArrayList<>();
    for (int i = 1; i <= size; i++) {
      employees.add(
          new EmployeeEntity(
              UUID.randomUUID().toString(),
              (long) i,
              "firstName" + i,
              "lastname" + i,
              "emailId@gmail.com"));
    }
    return employees;
  }
}

package com.macd.employee.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class EmployeeEntity {

  @Id private String Id;
  private Long empId;
  private String firstName;
  private String lastName;
  private String emailId;

  public EmployeeEntity() {
  }

  public EmployeeEntity(String id, Long empId, String firstName, String lastName, String emailId) {
    Id = id;
    this.empId = empId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.emailId = emailId;
  }

  public String getId() {
    return Id;
  }

  public void setId(String id) {
    Id = id;
  }

  public Long getEmpId() {
    return empId;
  }

  public void setEmpId(Long empId) {
    this.empId = empId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }
}

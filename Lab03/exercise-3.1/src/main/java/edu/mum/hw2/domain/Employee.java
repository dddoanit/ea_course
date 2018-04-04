/**
* Author: DatDoan
* Created Date: Apr 4, 2018
*/
package edu.mum.hw2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
  @Id
  @GeneratedValue
  private int employeeNumber;
  
  private String name;
  
  @ManyToOne
  @JoinColumn(name = "department_id")
  private Department department;
  
  @ManyToOne
  @JoinColumn(name = "OFFICE_ID")
  private Office office;

  public int getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(int employeeNumber) {
    this.employeeNumber = employeeNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
}

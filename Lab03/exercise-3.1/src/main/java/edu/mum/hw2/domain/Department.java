/**
 * Author: DatDoan Created Date: Apr 4, 2018
 */
package edu.mum.hw2.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
  @Id
  @GeneratedValue
  private int id;

  private String name;

  @OneToMany(mappedBy = "department")
  private List<Employee> employees = new ArrayList<>();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}

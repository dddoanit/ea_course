/**
* Author: DatDoan
* Created Date: Apr 4, 2018
*/
package edu.mum.hw2.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Office {
  @Id
  @GeneratedValue
  private int id;
  
  private int roomNumber;
  private int building;
  @OneToMany(mappedBy="office")
  private List<Employee> emmployees;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public int getRoomNumber() {
    return roomNumber;
  }
  public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
  }
  public int getBuilding() {
    return building;
  }
  public void setBuilding(int building) {
    this.building = building;
  }
  public List<Employee> getEmmployees() {
    return emmployees;
  }
  public void setEmmployees(List<Employee> emmployees) {
    this.emmployees = emmployees;
  }
  
}

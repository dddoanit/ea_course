/**
* Author: DatDoan
* Created Date: Apr 4, 2018
*/
package edu.mum.hw2.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {
  @Id
  private int id;
  
  private int courseNumber;
  private String name;
  
  @ManyToMany(mappedBy="courses")
  private List<Student> students = new ArrayList<>();
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public int getCourseNumber() {
    return courseNumber;
  }
  public void setCourseNumber(int courseNumber) {
    this.courseNumber = courseNumber;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
}

/**
 * Author: DatDoan Created Date: Apr 4, 2018
 */
package edu.mum.hw2.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {
  @Id
  private int studentId;

  private String firstName;
  private String lastName;

  @ManyToMany
  @JoinTable(name = "STUDENT_COURSE", joinColumns = @JoinColumn(name = "STUDENT_ID"),
      inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
  private List<Course> courses = new ArrayList<>();

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
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

}

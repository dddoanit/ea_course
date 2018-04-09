/**
* Author: DatDoan
* Created Date: Apr 7, 2018
*/
package cs544.extra_credit_w1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BENEFICIARY")
public class Beneficiary {
  @Id
  @GeneratedValue
  @Column(name = "ID")
  private int id;
  
  @Column(name = "NAME")
  private String name;
  
  @ManyToOne
  @JoinColumn(name = "PROJECT_ID")
  private Project project;

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

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }
  
}

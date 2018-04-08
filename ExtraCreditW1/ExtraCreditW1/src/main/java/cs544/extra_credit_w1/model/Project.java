/**
* Author: DatDoan
* Created Date: Apr 7, 2018
*/
package cs544.extra_credit_w1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PROJECT")
public class Project {
  @Id
  @GeneratedValue
  @Column(name = "ID")
  private int id;
  
  @Lob
  @Column(name = "DESCRIPTION")
  private String desciption;
  
  @Column(name = "LOCATION")
  private String location;
  
  @Column(name = "START_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date startDate;
  
  @Column(name = "END_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date endDate;
  
  @Column(name = "STATUS")
  @Enumerated(EnumType.STRING)
  private ProjectStatusEnum status;
  
  @OneToMany(mappedBy = "project")
  private List<Task> tasks = new ArrayList<>();
  
  @OneToMany(mappedBy = "project")
  private List<Beneficiary> beneficiaries = new ArrayList<>();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDesciption() {
    return desciption;
  }

  public void setDesciption(String desciption) {
    this.desciption = desciption;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public ProjectStatusEnum getStatus() {
    return status;
  }

  public void setStatus(ProjectStatusEnum status) {
    this.status = status;
  }

  public List<Task> getTasks() {
    return tasks;
  }

  public void setTasks(List<Task> tasks) {
    this.tasks = tasks;
  }

  public List<Beneficiary> getBeneficiaries() {
    return beneficiaries;
  }

  public void setBeneficiaries(List<Beneficiary> beneficiaries) {
    this.beneficiaries = beneficiaries;
  }
  
}

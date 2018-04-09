/**
* Author: DatDoan
* Created Date: Apr 7, 2018
*/
package cs544.extra_credit_w1.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "VOLUNTEER")
public class Volunteer {
  @Id
  @GeneratedValue
  @Column(name = "ID")
  private int id;
  
  @Column(name = "NAME")
  private String name;
  
  @OneToMany(mappedBy="volunteer")
  private List<TaskVolunteer> taskVolunteers = new ArrayList<>();
  
  @OneToMany(mappedBy="volunteer", cascade = CascadeType.ALL)
  private List<VolunteerResource> volunteerResources = new ArrayList<>();

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

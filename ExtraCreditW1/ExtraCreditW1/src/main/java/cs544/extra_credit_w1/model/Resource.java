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
@Table(name = "RESOURCE")
public class Resource {
  @Id
  @GeneratedValue
  private int id;
  
  @Column(name = "TYPE")
  private String type;
  
  @OneToMany(mappedBy="resource", cascade = CascadeType.ALL)
  private List<TaskResource> taskResources = new ArrayList<>();
}

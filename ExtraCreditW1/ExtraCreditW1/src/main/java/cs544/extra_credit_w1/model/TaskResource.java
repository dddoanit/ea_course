/**
* Author: DatDoan
* Created Date: Apr 7, 2018
*/
package cs544.extra_credit_w1.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "TASK_RESOURCE")
public class TaskResource {
  @EmbeddedId
  private TaskResourceId pk = new TaskResourceId();
  
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "TASK_ID")
  @MapsId("taskId")
  private Task task;
  
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "RESOURCE_ID")
  @MapsId("resourceId")
  private Resource resource;
  
  @Column(name = "NUM_RESOURCE")
  private int numResource;
  
}

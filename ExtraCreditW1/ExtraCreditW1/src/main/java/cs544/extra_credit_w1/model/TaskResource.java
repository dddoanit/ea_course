/**
* Author: DatDoan
* Created Date: Apr 7, 2018
*/
package cs544.extra_credit_w1.model;

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
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "TASK_ID")
  @MapsId("taskId")
  private Task task;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "RESOURCE_ID")
  @MapsId("resourceId")
  private Resource resource;
  
  @Column(name = "NUM_RESOURCE")
  private int numResource;

  public TaskResource() {
    
  }
  
  public TaskResource(Task task, Resource resource) {
    pk.setTaskId(task.getId());
    pk.setResourceId(resource.getId());
    this.task = task;
    this.resource = resource;
  }
  
  public TaskResourceId getPk() {
    return pk;
  }

  public void setPk(TaskResourceId pk) {
    this.pk = pk;
  }

  public Task getTask() {
    return task;
  }

  public void setTask(Task task) {
    this.task = task;
  }

  public Resource getResource() {
    return resource;
  }

  public void setResource(Resource resource) {
    this.resource = resource;
  }

  public int getNumResource() {
    return numResource;
  }

  public void setNumResource(int numResource) {
    this.numResource = numResource;
  }
  
}

/**
* Author: DatDoan
* Created Date: Apr 8, 2018
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
@Table(name = "TASK_VOLUNTEER")
public class TaskVolunteer {
  
  @EmbeddedId
  private TaskVolunteerId pk = new TaskVolunteerId();
  
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "TASK_ID")
  @MapsId("taskId")
  private Task task;
  
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "VOLUNTEER_ID")
  @MapsId("volunteerId")
  private Volunteer volunteer;
  
  @Column(name = "NUM_RESOURCE")
  private int numResource;

  public TaskVolunteer(Task task, Volunteer volunteer) {
    pk.setTaskId(task.getId());
    pk.setVolunteerId(volunteer.getId());
    this.task = task;
    this.volunteer = volunteer;
  }
  
  public TaskVolunteer() {
    
  }
  
  public TaskVolunteerId getPk() {
    return pk;
  }

  public void setPk(TaskVolunteerId pk) {
    this.pk = pk;
  }

  public Task getTask() {
    return task;
  }

  public void setTask(Task task) {
    this.task = task;
  }

  public Volunteer getVolunteer() {
    return volunteer;
  }

  public void setVolunteer(Volunteer volunteer) {
    this.volunteer = volunteer;
  }

  public int getNumResource() {
    return numResource;
  }

  public void setNumResource(int numResource) {
    this.numResource = numResource;
  }
  
}

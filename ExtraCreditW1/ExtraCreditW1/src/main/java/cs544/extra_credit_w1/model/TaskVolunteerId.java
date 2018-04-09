/**
* Author: DatDoan
* Created Date: Apr 8, 2018
*/
package cs544.extra_credit_w1.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class TaskVolunteerId implements Serializable{
  private static final long serialVersionUID = 1L;
  
  private int taskId;
  private int volunteerId;
  public int getTaskId() {
    return taskId;
  }
  public void setTaskId(int taskId) {
    this.taskId = taskId;
  }
  public int getVolunteerId() {
    return volunteerId;
  }
  public void setVolunteerId(int volunteerId) {
    this.volunteerId = volunteerId;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + taskId;
    result = prime * result + volunteerId;
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TaskVolunteerId other = (TaskVolunteerId) obj;
    if (taskId != other.taskId)
      return false;
    if (volunteerId != other.volunteerId)
      return false;
    return true;
  }
  
}

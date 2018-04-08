/**
* Author: DatDoan
* Created Date: Apr 7, 2018
*/
package cs544.extra_credit_w1.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class TaskResourceId implements Serializable{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private int taskId;
  
  private int resourceId;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + resourceId;
    result = prime * result + taskId;
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
    TaskResourceId other = (TaskResourceId) obj;
    if (resourceId != other.resourceId)
      return false;
    if (taskId != other.taskId)
      return false;
    return true;
  }

}

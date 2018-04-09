/**
* Author: DatDoan
* Created Date: Apr 7, 2018
*/
package cs544.extra_credit_w1.model;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable
public class VolunteerResourceId implements Serializable{
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private int volunteerId;
  
  private int resourceId;

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + resourceId;
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
    VolunteerResourceId other = (VolunteerResourceId) obj;
    if (resourceId != other.resourceId)
      return false;
    if (volunteerId != other.volunteerId)
      return false;
    return true;
  }

  public int getVolunteerId() {
    return volunteerId;
  }

  public void setVolunteerId(int volunteerId) {
    this.volunteerId = volunteerId;
  }

  public int getResourceId() {
    return resourceId;
  }

  public void setResourceId(int resourceId) {
    this.resourceId = resourceId;
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
  }
  

}

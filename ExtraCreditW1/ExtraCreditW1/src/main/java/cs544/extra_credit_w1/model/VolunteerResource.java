/**
* Author: DatDoan
* Created Date: Apr 7, 2018
*/
package cs544.extra_credit_w1.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "VOLUNTEER_RESOURCE")
public class VolunteerResource {
  @EmbeddedId
  private VolunteerResourceId pk = new VolunteerResourceId();
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "VOLUNTEER_ID")
  @MapsId("volunteerId")
  private Volunteer volunteer;
  
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "RESOURCE_ID")
  @MapsId("resourceId")
  private Resource resource;
  
//  @Column(name = "NUM_RESOURCE")
//  private int numResource;

  public VolunteerResource() {
    
  }
  
  public VolunteerResource(Volunteer volunteer, Resource resource) {
    pk.setResourceId(resource.getId());
    pk.setVolunteerId(volunteer.getId());
    this.volunteer = volunteer;
    this.resource = resource;
  }
  
  public VolunteerResourceId getPk() {
    return pk;
  }

  public void setPk(VolunteerResourceId pk) {
    this.pk = pk;
  }

  public Volunteer getVolunteer() {
    return volunteer;
  }

  public void setVolunteer(Volunteer volunteer) {
    this.volunteer = volunteer;
  }

  public Resource getResource() {
    return resource;
  }

  public void setResource(Resource resource) {
    this.resource = resource;
  }

//  public int getNumResource() {
//    return numResource;
//  }
//
//  public void setNumResource(int numResource) {
//    this.numResource = numResource;
//  }
  
}

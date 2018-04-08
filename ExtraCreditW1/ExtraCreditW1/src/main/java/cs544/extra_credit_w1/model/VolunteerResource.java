/**
* Author: DatDoan
* Created Date: Apr 7, 2018
*/
package cs544.extra_credit_w1.model;

import javax.persistence.CascadeType;
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
  
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "VOLUNTEER_ID")
  @MapsId("volunteerId")
  private Volunteer volunteer;
  
  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name = "RESOURCE_ID")
  @MapsId("resourceId")
  private Resource resource;
  
}

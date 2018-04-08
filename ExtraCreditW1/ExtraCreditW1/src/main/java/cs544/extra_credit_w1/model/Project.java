/**
* Author: DatDoan
* Created Date: Apr 7, 2018
*/
package cs544.extra_credit_w1.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PROJECT")
public class Project {
  @Id
  @GeneratedValue
  @Column(name = "ID")
  private int id;
  
  @Lob
  @Column(name = "DESCRIPTION")
  private String desciption;
  
  @Column(name = "LOCATION")
  private String location;
  
  @Column(name = "START_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date startDate;
  
  @Column(name = "END_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date endDate;
  
  @OneToMany(mappedBy = "project")
  private List<Task> tasks = new ArrayList<>();
  
  @OneToMany(mappedBy = "project")
  private List<Beneficiary> beneficiaries = new ArrayList<>();
  
}

/**
* Author: DatDoan
* Created Date: Apr 7, 2018
*/
package cs544.extra_credit_w1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VOLUNTEER")
public class Volunteer {
  @Id
  @GeneratedValue
  private int id;
  
  @Column(name = "NAME")
  private String name;
  
}

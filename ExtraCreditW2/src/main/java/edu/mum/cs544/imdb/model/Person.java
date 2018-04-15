/**
* Author: DatDoan
* Created Date: Apr 14, 2018
*/
package edu.mum.cs544.imdb.model;

import java.util.Date;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="personType", discriminatorType=DiscriminatorType.STRING)
public abstract class Person {
  @Id
  @GeneratedValue
  private int id;
  
  private String name;
  
  @Temporal(TemporalType.DATE)
  private Date placeOfBirth;
  
  private String biography;
  
  private String pictureUrl;
}

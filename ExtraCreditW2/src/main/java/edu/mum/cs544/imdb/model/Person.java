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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Date getPlaceOfBirth() {
    return placeOfBirth;
  }

  public void setPlaceOfBirth(Date placeOfBirth) {
    this.placeOfBirth = placeOfBirth;
  }

  public String getBiography() {
    return biography;
  }

  public void setBiography(String biography) {
    this.biography = biography;
  }

  public String getPictureUrl() {
    return pictureUrl;
  }

  public void setPictureUrl(String pictureUrl) {
    this.pictureUrl = pictureUrl;
  }
  
}

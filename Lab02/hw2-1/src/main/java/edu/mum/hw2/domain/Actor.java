/**
* Author: DatDoan
* Created Date: Apr 3, 2018
*/
package edu.mum.hw2.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Actor {
  @Column(name="character_actor")
  private String character;
  @Enumerated(EnumType.STRING)
  private Rating rating;
  private String name;
  
  public String getCharacter() {
    return character;
  }
  public void setCharacter(String character) {
    this.character = character;
  }
 
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Rating getRating() {
    return rating;
  }
  public void setRating(Rating rating) {
    this.rating = rating;
  }
  
  @Override
  public String toString() {
    return "Actor [character=" + character + ", rating=" + rating + ", name=" + name + "]";
  }
}

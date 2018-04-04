/**
* Author: DatDoan
* Created Date: Apr 3, 2018
*/
package edu.mum.hw2.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CD")
public class CD extends Product{
  private String artist;

  public String getArtist() {
    return artist;
  }

  public void setArtist(String artist) {
    this.artist = artist;
  }
  
}

/**
* Author: DatDoan
* Created Date: Apr 3, 2018
*/
package edu.mum.hw2.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DVD")
public class DVD extends Product{
  private String genre;

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

}

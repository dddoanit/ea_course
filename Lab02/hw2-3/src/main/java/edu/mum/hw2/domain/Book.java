/**
* Author: DatDoan
* Created Date: Apr 3, 2018
*/
package edu.mum.hw2.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book extends Product{
  private String title;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

}

/**
* Author: DatDoan
* Created Date: Apr 4, 2018
*/
package edu.mum.hw2.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer {
  @Id
  private int id;
  private String name;

  @OneToMany
  @JoinColumn(name = "CUST_ID")
  private List<Reservation> reservations = new ArrayList<>();

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

  public List<Reservation> getReservations() {
    return reservations;
  }

  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
  }
  
}

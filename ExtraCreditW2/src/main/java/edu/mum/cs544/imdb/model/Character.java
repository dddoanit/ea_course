/**
* Author: DatDoan
* Created Date: Apr 14, 2018
*/
package edu.mum.cs544.imdb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "`character`")
public class Character {
  @Id
  @GeneratedValue
  private int id;
  
  private String name;
  
  @ManyToOne
  @JoinColumn(name = "episode_id")
  private Episode episode;
  
  
}

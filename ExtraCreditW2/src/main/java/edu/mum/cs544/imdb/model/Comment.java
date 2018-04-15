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

@Entity
public class Comment {
  @Id
  @GeneratedValue
  private int id;
  
  private String comment;
  
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
  
  @ManyToOne
  @JoinColumn(name = "episode_id")
  private Episode episode;
}

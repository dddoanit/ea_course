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

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Episode getEpisode() {
    return episode;
  }

  public void setEpisode(Episode episode) {
    this.episode = episode;
  }
  
}

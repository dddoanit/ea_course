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

  public Episode getEpisode() {
    return episode;
  }

  public void setEpisode(Episode episode) {
    this.episode = episode;
  }
  
}

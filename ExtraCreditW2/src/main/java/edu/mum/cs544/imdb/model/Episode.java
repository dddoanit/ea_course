/**
* Author: DatDoan
* Created Date: Apr 14, 2018
*/
package edu.mum.cs544.imdb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Episode {
  @Id
  @GeneratedValue
  private int id;
  
  private String description;
  
  @Temporal(TemporalType.DATE)
  private Date dateOfAired;
  
  @ManyToOne
  @JoinColumn(name = "season_id")
  private Season season;
  
  @OneToMany(mappedBy = "episode")
  private List<Character> characters = new ArrayList<>();
  
  @ManyToMany
  @JoinTable(name = "episode_director", joinColumns = @JoinColumn(name = "episode_id"),
      inverseJoinColumns = @JoinColumn(name = "director_id"))
  private List<Director> directors = new ArrayList<>();
  
  @ManyToMany
  @JoinTable(name = "episode_artist", joinColumns = @JoinColumn(name = "episode_id"),
      inverseJoinColumns = @JoinColumn(name = "artist_id"))
  private List<Artist> artists = new ArrayList<>();
  
  @OneToMany(mappedBy = "episode")
  private List<Comment> comments = new ArrayList<>();
}

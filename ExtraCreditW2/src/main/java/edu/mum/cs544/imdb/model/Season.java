/**
* Author: DatDoan
* Created Date: Apr 14, 2018
*/
package edu.mum.cs544.imdb.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Season {
  @Id
  @GeneratedValue
  private int id;
  
  private String name;
  
  @ManyToOne
  @JoinColumn(name = "tvshow_id")
  private TvShow tvShow;
  
  @OneToMany(mappedBy = "season")
  private List<Episode> episodes = new ArrayList<>();
}

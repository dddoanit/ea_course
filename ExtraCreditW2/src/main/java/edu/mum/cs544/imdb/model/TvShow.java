/**
 * Author: DatDoan Created Date: Apr 14, 2018
 */
package edu.mum.cs544.imdb.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TvShow {
  public enum Genre {
    ACTION, ADVENTURE, HORROR, ROMANCE, COMEDY, DRAMA, DOCUMENTARY
  };

  @Id
  @GeneratedValue
  private int id;

  private String name;

  @Enumerated(EnumType.STRING)
  private Genre genre;
  
  @Embedded
  private GeneralInfo generalInfo;
  
  @OneToMany(mappedBy = "tvShow")
  private List<Season> seasons = new ArrayList<>();
  
}

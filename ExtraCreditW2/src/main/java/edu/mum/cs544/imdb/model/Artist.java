/**
* Author: DatDoan
* Created Date: Apr 14, 2018
*/
package edu.mum.cs544.imdb.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

@Entity
@DiscriminatorValue("Artist")
public class Artist extends Person {
  
  @ManyToMany(mappedBy = "artists")
  private List<Episode> episodes = new ArrayList<>();
}

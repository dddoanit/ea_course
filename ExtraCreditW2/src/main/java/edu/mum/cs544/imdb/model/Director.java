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
@DiscriminatorValue("Director")
public class Director extends Person {
  @ManyToMany(mappedBy = "directors")
  private List<Episode> episodes = new ArrayList<>();
  
}

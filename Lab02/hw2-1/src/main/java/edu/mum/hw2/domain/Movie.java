package edu.mum.hw2.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="MOVIE")
public class Movie {
  public enum Category {
    COMEDY, DRAMA
  }

  @Id
  @GeneratedValue
  private long id;
  
  private String name;
  
  @Enumerated(EnumType.STRING)
  private Category category;
  
  private int rating;
  
  @ElementCollection
  @CollectionTable(name="MOVIE_COMMENT")
  @Column(name="comment")
  private List<String> comments = new ArrayList<>();
  
  @ElementCollection
  @CollectionTable(name ="MOVIE_ACTOR")
  private List<Actor> actors = new ArrayList<>();
  
  @Lob
  private byte[] cover;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public int getRating() {
    return rating;
  }

  public void setRating(int rating) {
    this.rating = rating;
  }

  public List<String> getComments() {
    return comments;
  }

  public void setComments(List<String> comments) {
    this.comments = comments;
  }

  public List<Actor> getActors() {
    return actors;
  }

  public void setActors(List<Actor> actors) {
    this.actors = actors;
  }

  public byte[] getCover() {
    return cover;
  }

  public void setCover(byte[] cover) {
    this.cover = cover;
  }

  @Override
  public String toString() {
    return "Movie [id=" + id + ", name=" + name + ", category=" + category + ", rating=" + rating
        + ", comments=" + comments + ", actors=" + actors + ", cover=" + Arrays.toString(cover)
        + "]";
  }

}

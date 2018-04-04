package edu.mum.hw2.control;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import edu.mum.hw2.domain.Actor;
import edu.mum.hw2.domain.Movie;
import edu.mum.hw2.domain.Rating;

public class Application {

  private static EntityManagerFactory emf;

  static {
    try {
      emf = Persistence.createEntityManagerFactory("cs544");
    } catch (Throwable ex) {
      ex.printStackTrace();
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static void main(String[] args) throws InterruptedException {
    addMovies();
    printMoviesReport();
    
    emf.close();
  }

  private static void printMoviesReport() {
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {

      System.out.println("======== REPORT =======");
      tx.begin();
      List<Movie> movies = em.createQuery("From Movie", Movie.class).getResultList();
      for (Movie m: movies) {
        System.out.println(m.toString());
      }
      tx.commit();

    } catch (Throwable e) {
      e.printStackTrace();
      if ((tx != null) && (tx.isActive()))
        tx.rollback();
    } finally {
      if ((em != null) && (em.isOpen()))
        em.close();
    }
  }

  private static void addMovies() {
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {

      //
      // Transaction 1 Persist
      //
      System.out.println("======== TRANSACTION 1 =======");
      tx.begin();
      
      Movie movie = new Movie();
      movie.setName("Pitch Perfect 3");
      movie.setCover(getImageByte("movie.jpg"));
      movie.setRating(6);
      movie.setCategory(Movie.Category.DRAMA);
      movie.getComments().add("Good");
      
      Actor actor1 = new Actor();
      actor1.setName("Anna Kendrick");
      actor1.setCharacter("NA");
      actor1.setRating(Rating.GOOD);
      
      Actor actor2 = new Actor();
      actor2.setName("Rebel Wilson");
      actor2.setCharacter("NA");
      actor2.setRating(Rating.GOOD);
      
      movie.getActors().add(actor1);
      movie.getActors().add(actor2);
      em.persist(movie);

      tx.commit();

    } catch (Throwable e) {
      e.printStackTrace();
      if ((tx != null) && (tx.isActive()))
        tx.rollback();
    } finally {
      if ((em != null) && (em.isOpen()))
        em.close();
    }
  }
  
  private static byte[] getImageByte(String fileName) throws IOException {
    Path p = FileSystems.getDefault().getPath(fileName);
    byte[] fileData = Files.readAllBytes(p);
    return fileData;
  }

}

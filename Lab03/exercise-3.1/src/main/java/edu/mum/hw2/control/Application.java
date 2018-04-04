package edu.mum.hw2.control;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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
  
}

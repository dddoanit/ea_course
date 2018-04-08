package cs544.extra_credit_w1;

import java.text.ParseException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import org.apache.log4j.Logger;

public class App {
  private static Logger logger = Logger.getLogger(App.class);;

  private static final EntityManagerFactory emf;

  static {
    try {
      emf = Persistence.createEntityManagerFactory("cs544");
    } catch (Throwable ex) {
      ex.printStackTrace();
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static void main(String[] args) throws ParseException {
    EntityManager em = null;
    EntityTransaction tx = null;

    // fill the database

    try {
      em = emf.createEntityManager();
      tx = em.getTransaction();
      tx.begin();

      tx.commit();
    } catch (PersistenceException e) {
      if (tx != null) {
        logger.error("Rolling back:", e);
        tx.rollback();
      }
    } finally {
      if (em != null) {
        em.close();
      }
    }

  }


}

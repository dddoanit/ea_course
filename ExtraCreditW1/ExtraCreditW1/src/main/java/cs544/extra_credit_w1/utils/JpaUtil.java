/**
* Author: DatDoan
* Created Date: Apr 7, 2018
*/
package cs544.extra_credit_w1.utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
  private static final EntityManagerFactory emf;

  static {
    try {
      emf = Persistence.createEntityManagerFactory("cs544");
    } catch (Throwable ex) {
      ex.printStackTrace();
      throw new ExceptionInInitializerError(ex);
    }
  }
  
  public static EntityManagerFactory getEntityManagerFactory() {
    return emf;
  }
}

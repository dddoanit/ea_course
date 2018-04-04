package edu.mum.hw2.control;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import edu.mum.hw2.domain.Order;
import edu.mum.hw2.domain.OrderLine;
import edu.mum.hw2.domain.Product;

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
    addOrders();
    printOrdersReport();
    
    emf.close();
  }

  private static void printOrdersReport() {
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

  private static void addOrders() {
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    try {

      //
      // Transaction 1 Persist
      //
      System.out.println("======== TRANSACTION 1 =======");
      tx.begin();
      
      Product p1 = new Product();
      p1.setName("Product 1");
      p1.setDescription("Product 1");
      
      Product p2 = new Product();
      p2.setName("Product 2");
      p2.setDescription("Product 2");
      
      OrderLine line1 = new OrderLine();
      line1.setProduct(p1);
      line1.setQuantity(1);
      
      OrderLine line2 = new OrderLine();
      line2.setProduct(p2);
      line2.setQuantity(1);
      
      Order order = new Order();
      order.setDate(new Date());
      order.getOrderLines().add(line1);
      order.getOrderLines().add(line2);
      
      em.persist(order);
      
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

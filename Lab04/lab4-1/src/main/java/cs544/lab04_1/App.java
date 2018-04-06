package cs544.lab04_1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import org.apache.log4j.Logger;
import cs544.lab04_1.model.Airline;
import cs544.lab04_1.model.Airplane;
import cs544.lab04_1.model.Airport;
import cs544.lab04_1.model.Flight;

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
    fillDataBase();

    // Flights leaving USA capacity > 500
    try {
      em = emf.createEntityManager();
      tx = em.getTransaction();
      tx.begin();

      logger.trace("List all the flights:");
      List<Flight> flights = em.createQuery("from Flight", Flight.class).getResultList();
      printFlights(flights);

      logger.trace("All flights leaving the USA with a capacity > 500");
      flights = em.createQuery(
          "select f from Flight f join f.airplane a join f.origin o where o.country='USA' and a.capacity > 500",
          Flight.class).getResultList();
      printFlights(flights);

      logger.trace("All airlines that use A380 (model) airplanes");
      List<Airline> airlines = em.createQuery(
          "select distinct al from Airline al join al.flights f join f.airplane fal where fal.model='A380'",
          Airline.class).getResultList();
      logger.trace("Name");
      for (Airline airline : airlines) {
        logger.trace(airline.getName());
      }

      logger.trace("All fights using 747 planes that don t belong to  Star Alliance ");
      flights = em.createQuery(
          "select f from Flight f join f.airplane airplane join f.airline airline where airplane.model='747' and airline.name != 'Star Alliance'",
          Flight.class).getResultList();
      printFlights(flights);
      
      logger.trace("All flights leaving before 12pm on 08/07/2009");
      Query query = em.createQuery("select f from Flight f where f.departureDate = :departureDate and f.departureTime <= :departureTime", Flight.class);
      Date date = new Date();
      SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:ss a");
      date = df.parse("08/07/2009 12:00 PM");
      query.setParameter("departureDate", date, TemporalType.DATE);
      query.setParameter("departureTime", date, TemporalType.TIME);
      flights = query.getResultList();
      
      printFlights(flights);
      
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

  public static void printFlights(List<Flight> flights) {
    logger.trace(String.format("%-9s%-31s%-31s", "Flight:", "Departs:", "Arrives:"));
    for (Flight flight : flights) {
      logger.trace(String.format("%-7s  %-12s %7s %8s  %-12s %7s %8s", flight.getFlightnr(),
          flight.getOrigin().getCity(), flight.getDepartureDate(), flight.getDepartureTime(),
          flight.getDestination().getCity(), flight.getArrivalDate(), flight.getArrivalTime()));
    }
  }

  public static void fillDataBase() {
    EntityManager em = null;
    EntityTransaction tx = null;

    try {

      Airport mco = new Airport("MCO", "Orlando", "Florida", "USA");
      Airport mia = new Airport("MIA", "Miami", "Florida", "USA");

      Airplane airplane1 = new Airplane("56789", "A380", 519);

      Airline airline1 = new Airline("Delta");

      Flight flight1 = new Flight("DE 36", "08/06/2009", "7:10 pm", "06/25/2015", "9:00 am",
          airline1, mia, mco, airplane1);

      em = emf.createEntityManager();
      tx = em.getTransaction();
      tx.begin();

      em.persist(flight1);

      tx.commit();

    } catch (PersistenceException e) {
      if (tx != null) {
        logger.error("Rolling back", e);
        tx.rollback();
      }
    } finally {
      if (em != null) {
        em.close();
      }
    }
  }

}

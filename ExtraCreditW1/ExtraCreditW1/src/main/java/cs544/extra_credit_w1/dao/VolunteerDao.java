/**
* Author: DatDoan
* Created Date: Apr 7, 2018
*/
package cs544.extra_credit_w1.dao;

import javax.persistence.EntityManager;
import cs544.extra_credit_w1.model.Volunteer;
import cs544.extra_credit_w1.utils.JpaUtil;

public class VolunteerDao {
  private EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
  
  public Volunteer findById(int id) {
    return em.find(Volunteer.class, id);
  }
}

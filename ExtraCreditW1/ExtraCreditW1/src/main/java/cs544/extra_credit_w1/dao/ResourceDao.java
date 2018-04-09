/**
* Author: DatDoan
* Created Date: Apr 7, 2018
*/
package cs544.extra_credit_w1.dao;

import javax.persistence.EntityManager;
import cs544.extra_credit_w1.model.Resource;
import cs544.extra_credit_w1.utils.JpaUtil;

public class ResourceDao {
  private EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
  
  public Resource findById(int id) {
    return em.find(Resource.class, id);
  }
}

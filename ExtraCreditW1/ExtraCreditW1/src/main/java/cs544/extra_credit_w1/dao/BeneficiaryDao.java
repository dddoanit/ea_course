/**
* Author: DatDoan
* Created Date: Apr 7, 2018
*/
package cs544.extra_credit_w1.dao;

import javax.persistence.EntityManager;
import cs544.extra_credit_w1.model.Beneficiary;
import cs544.extra_credit_w1.utils.JpaUtil;

public class BeneficiaryDao {
  private EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
  
  public Beneficiary findById(int id) {
    return em.find(Beneficiary.class, id);
  }
}

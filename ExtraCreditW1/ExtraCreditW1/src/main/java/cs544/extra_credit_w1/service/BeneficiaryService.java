/**
* Author: DatDoan
* Created Date: Apr 8, 2018
*/
package cs544.extra_credit_w1.service;

import cs544.extra_credit_w1.dao.BeneficiaryDao;
import cs544.extra_credit_w1.model.Beneficiary;

public class BeneficiaryService {
  private BeneficiaryDao beneficiaryDao = new BeneficiaryDao();
  
  public Beneficiary findById(int id) {
    return beneficiaryDao.findById(id);
  }
  
}

/**
* Author: DatDoan
* Created Date: Apr 8, 2018
*/
package cs544.extra_credit_w1.service;

import cs544.extra_credit_w1.dao.ResourceDao;
import cs544.extra_credit_w1.model.Resource;

public class ResourceService {
  private ResourceDao resourceDao = new ResourceDao();
  
  public Resource findById(int id) {
    return resourceDao.findById(id);
  }
  
}

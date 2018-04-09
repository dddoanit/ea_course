/**
* Author: DatDoan
* Created Date: Apr 8, 2018
*/
package cs544.extra_credit_w1.service;

import cs544.extra_credit_w1.dao.VolunteerDao;
import cs544.extra_credit_w1.model.Volunteer;

public class VolunteerService {
  private VolunteerDao volunteerDao = new VolunteerDao();
  
  public Volunteer findById(int id) {
    return volunteerDao.findById(id);
  }
  
}

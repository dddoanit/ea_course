/**
* Author: DatDoan
* Created Date: Apr 7, 2018
*/
package cs544.extra_credit_w1.service;

import java.util.List;
import cs544.extra_credit_w1.dao.ProjectDao;
import cs544.extra_credit_w1.model.Project;
import cs544.extra_credit_w1.model.ProjectStatusEnum;
import cs544.extra_credit_w1.model.Resource;
import cs544.extra_credit_w1.model.Volunteer;

public class ProjectService {
  private ProjectDao projectDao = new ProjectDao();
  
  /**
   * List information about projects and their beneficiaries
   * @return
   */
  public List<Project> findAll() {
    return projectDao.findAll();
  }
  
  /**
   * List projects by status
   * @return
   */
  public List<Project> findByStatus(ProjectStatusEnum status) {
    return projectDao.findByStatus(status);
  }
  
  /**
   * Look for projects that requires a particular type of resource
   * @param resource
   * @return
   */
  public List<Project> findByResource(Resource resource) {
    return projectDao.findByResource(resource);
  }
  
  /**
   * List projects and tasks where a volunteer have offered services, ordered by date of the task.
   * @param volunteer
   * @return
   */
  public List<Project> findByVolunteer(Volunteer volunteer) {
    return projectDao.findByVolunteer(volunteer);
  }
  
  /**
   * Search projects by keywords and location
   * @param location
   * @return
   */
  public List<Project> findByLocation(String location) {
    return projectDao.findByLocation(location);
  }
}

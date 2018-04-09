/**
* Author: DatDoan
* Created Date: Apr 7, 2018
*/
package cs544.extra_credit_w1.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import cs544.extra_credit_w1.model.Project;
import cs544.extra_credit_w1.model.ProjectStatusEnum;
import cs544.extra_credit_w1.model.Resource;
import cs544.extra_credit_w1.model.Volunteer;
import cs544.extra_credit_w1.utils.JpaUtil;

public class ProjectDao {
  private EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
  
  public Project findById(int id) {
    return em.find(Project.class, id);
  }
  
  /**
   * List information about projects and their beneficiaries
   * @return
   */
  public List<Project> findAll() {
   return em.createQuery("select p from Project p", Project.class).getResultList();
  }
  
  /**
   * List projects by status
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<Project> findByStatus(ProjectStatusEnum status) {
    Query query = em.createQuery("select p from Project p where p.status = :status", Project.class);
    query.setParameter("status", status);
    return query.getResultList();
   }
  
  /**
   * Look for projects that requires a particular type of resource
   * @param resource
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<Project> findByResource(Resource resource) {
    Query query = em.createQuery(
        "select p from Project p join p.task t join  t.taskResources r where r.resourceId = :resourceId",
        Project.class);
    query.setParameter("resourceId", resource.getId());
    return query.getResultList();
   }
  
  /**
   * List projects and tasks where a volunteer have offered services, ordered by date of the task.
   * @param volunteer
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<Project> findByVolunteer(Volunteer volunteer) {
    Query query = em.createQuery(
        "select p from Project p join p.task t join  t.volunteer v where v.id = :volunteerId",
        Project.class);
    query.setParameter("volunteerId", volunteer.getId());
    return query.getResultList();
   }
  
  /**
   * Search projects by keywords and location
   * @param location
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<Project> findByLocation(String location) {
    Query query = em.createQuery(
        "select p from Project p where v.location like :location",
        Project.class);
    query.setParameter("location", "%" + location + "%");
    return query.getResultList();
   }
}

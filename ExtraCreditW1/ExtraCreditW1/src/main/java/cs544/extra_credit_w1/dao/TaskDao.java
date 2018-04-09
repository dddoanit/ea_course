/**
* Author: DatDoan
* Created Date: Apr 7, 2018
*/
package cs544.extra_credit_w1.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import cs544.extra_credit_w1.model.Project;
import cs544.extra_credit_w1.model.Task;
import cs544.extra_credit_w1.utils.JpaUtil;

public class TaskDao {
  private EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
  
  public void create(Task task) {
    em.getTransaction().begin();
    em.persist(task);
    em.getTransaction().commit();
  }
  
  public void delete(Task task) {
    Task deleteTask = em.find(Task.class, task.getId());
    if (deleteTask != null) {
      em.getTransaction().begin();
      em.remove(deleteTask);
      em.getTransaction().commit();
    }
  }
  
  public void update(Task task) {
    em.getTransaction().begin();
    em.merge(task);
    em.getTransaction().commit();
  }
  
  /**
   * List tasks for a project
   * @param project
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<Task> findByProject(Project project) {
    Query query = em.createQuery(
        "select t from Task t join t.project p where p.id = :projectId",
        Task.class);
    query.setParameter("projectId", project.getId());
    return query.getResultList();
  }
}

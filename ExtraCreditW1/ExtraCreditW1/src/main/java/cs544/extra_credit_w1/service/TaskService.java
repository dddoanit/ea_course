/**
* Author: DatDoan
* Created Date: Apr 7, 2018
*/
package cs544.extra_credit_w1.service;

import java.util.List;
import cs544.extra_credit_w1.dao.TaskDao;
import cs544.extra_credit_w1.model.Project;
import cs544.extra_credit_w1.model.Task;

public class TaskService {
  private TaskDao taskDao = new TaskDao();
  
  public void create(Task task) {
    taskDao.create(task);
  }
  
  public void delete(Task task) {
    taskDao.delete(task);
  }
  
  public void update(Task task) {
    taskDao.update(task);
  }
  
  /**
   * List tasks for a project
   * @param project
   * @return
   */
  public List<Task> findByProject(Project project) {
    return taskDao.findByProject(project);
  }
}

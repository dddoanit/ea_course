/**
 * Author: DatDoan Created Date: Apr 8, 2018
 */
package cs544.extra_credit_w1.service;

import static org.junit.Assert.fail;
import java.time.LocalDate;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import cs544.extra_credit_w1.model.Project;
import cs544.extra_credit_w1.model.Resource;
import cs544.extra_credit_w1.model.Task;
import cs544.extra_credit_w1.model.TaskResource;
import cs544.extra_credit_w1.model.TaskStatusEnum;
import cs544.extra_credit_w1.model.TaskVolunteer;
import cs544.extra_credit_w1.model.Volunteer;

public class TaskServiceTest {

  private static TaskService taskService = new TaskService();
  private static ProjectService projectService = new ProjectService();
  private static VolunteerService volunteerService = new VolunteerService();
  private static ResourceService resourceService = new ResourceService();
  
  private static Project project;
  private static Volunteer volunteer;
  private static Resource resource;
  
  private static Task task = new Task();
  
  @BeforeClass
  public static void setUp() throws Exception {
    project = projectService.findById(1);
    volunteer = volunteerService.findById(1);
    resource = resourceService.findById(1);
    task = new Task();
    task.setProject(project);
    task.setStartDate(java.sql.Date.valueOf(LocalDate.now()));
    task.setEndDate(java.sql.Date.valueOf(LocalDate.now().plusDays(10)));
    task.setStatus(TaskStatusEnum.READY);
    taskService.create(task);
  }

  @AfterClass
  public static void tearDown() throws Exception {
    
  }

  @Test
  public void test() {
    if (task.getId() == 0) {
      fail("Failed to create task");
    }
    TaskVolunteer taskVolunteer = new TaskVolunteer(task, volunteer);
    task.getTaskVolunteers().add(taskVolunteer);
    
    TaskResource taskResource = new TaskResource(task, resource);
    task.getTaskResources().add(taskResource);
    
    taskService.update(task);
    
    if (task.getTaskVolunteers().size() == 0) {
      fail("Failed to update task");
    }
    taskService.delete(task);
  }
  
}

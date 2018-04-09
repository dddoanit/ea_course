/**
 * Author: DatDoan Created Date: Apr 8, 2018
 */
package cs544.extra_credit_w1.service;

import static org.junit.Assert.fail;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import cs544.extra_credit_w1.model.Project;
import cs544.extra_credit_w1.model.ProjectStatusEnum;
import cs544.extra_credit_w1.model.Resource;
import cs544.extra_credit_w1.model.Task;
import cs544.extra_credit_w1.model.Volunteer;

public class ProjectServiceTest {

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
  }

  @AfterClass
  public static void tearDown() throws Exception {
    
  }

  /**
   * List information about projects and their beneficiaries
   */
  @Test
  public void findAll() {
    List<Project> projects = projectService.findAll();
    if (projects.size() == 0) {
      fail("Fail to test findAll()");
    }
  }
  
  /**
   * List projects by status
   */
  @Test
  public void findByStatus() {
    List<Project> projects = projectService.findByStatus(ProjectStatusEnum.READY);
    if (projects.size() == 0) {
      fail("Fail to test findByStatus()");
    }
  }
  
  /**
   * Look for projects that requires a particular type of resource
   */
  @Test
  public void findByResource() {
    List<Project> projects = projectService.findByResource(resource);
    if (projects.size() == 0) {
      fail("Fail to test findByResource()");
    }
  }
  
  /**
   * List projects and tasks where a volunteer have offered services, ordered by date of the task.
   */
  @Test
  public void findByVolunteer() {
    List<Project> projects = projectService.findByVolunteer(volunteer);
    if (projects.size() == 0) {
      fail("Fail to test findByVolunteer()");
    }
  }
  
  /**
   *  Search projects by keywords and location
   */
  @Test
  public void findByLocation() {
    List<Project> projects = projectService.findByLocation("FairField");
    if (projects.size() == 0) {
      fail("Fail to test findByLocation()");
    }
  }
  
}

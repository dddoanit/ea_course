/**
 * Author: DatDoan Created Date: Apr 12, 2018
 */
package cs544.exercise8_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

  @Autowired
  private StudentService studentService;

  @RequestMapping(value = {"/", "/StudentsCourseController"}, method = RequestMethod.GET)
  public String home(@RequestParam(value ="studentid", required = false) String studentIdStr, Model model) {

    long studentid = -1;
    Student student = null;

    if (studentIdStr != null && studentIdStr.matches("\\d+")) {
      studentid = Long.parseLong(studentIdStr);
      student = studentService.getStudent(studentid);
    }
    model.addAttribute("student", student);
    return "student";
  }
}

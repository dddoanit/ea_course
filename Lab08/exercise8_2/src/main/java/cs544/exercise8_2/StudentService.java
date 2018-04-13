package cs544.exercise8_2;

import org.hibernate.Hibernate;
import org.springframework.transaction.annotation.Transactional;

public class StudentService {
  private StudentDAO studentDAO;

  public StudentService() {}

  @Transactional
  public Student getStudent(long studentid) {
    Student student = studentDAO.load(studentid);;
    Hibernate.initialize(student.getCourselist());
    return student;
  }

  public void setStudentDAO(StudentDAO studentdao) {
    this.studentDAO = studentdao;
  }

}

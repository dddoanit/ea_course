package cs544.exercise8_2;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class StudentDAO {

  private SessionFactory sf;
  public StudentDAO(SessionFactory sf) {
    this.sf = sf;
  }

  @Transactional
  public void init() {
    Session session;
    try {
      session = sf.getCurrentSession();
    }catch(HibernateException ex) {
      session = sf.openSession();
    }
    org.hibernate.Transaction tx = session.beginTransaction();
    Student student = new Student(11334, "Frank", "Brown");
    Course course1 = new Course(1101, "Java", "A");
    Course course2 = new Course(1102, "Math", "B-");
    student.addCourse(course1);
    student.addCourse(course2);

    session.persist(student);
    tx.commit();
  }

  public Student load(long studentid) {
    Student student = (Student) sf.getCurrentSession().get(Student.class, studentid);
    return student;
  }
}

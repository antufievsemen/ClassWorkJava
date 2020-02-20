package university;

import generator.GeneratorOfStudents;
import university.robots.FizikRobot;
import university.robots.MathRobot;
import university.robots.OOPRobot;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

import static generator.GeneratorOfStudents.generateStudent;


public class ClassRoom extends Thread {

  public static volatile BlockingDeque<Student> deque;

  public ClassRoom() {
    deque = new LinkedBlockingDeque<>();
  }

  public void createStudent() {
    deque.addLast(generateStudent());
  }

  public synchronized void deleteStudent(Student student) {
    deque.remove(student);
  }

  private static boolean hasStudent(BlockingDeque<Student> deque, String lesson) {
    int studentCount = 0;
    for (Student student : deque) {
      if (student.getLesson().equals(lesson)) {
        return true;
      }

      if (studentCount++ == 9) {
        return false;
      }
    }

    return false;
  }

  private static Student getStudent(BlockingDeque<Student> deque, String lesson) {
    for (Student student : deque) {
      if (student.getLesson().equals(lesson)) {
        return student;
      }

    }
    return null;

  }

  @Override
  public void run() {
    GeneratorOfStudents generator = new GeneratorOfStudents();
    generator.start();
    while (!deque.isEmpty()) {
      if (hasStudent(deque, "Math")) {
        Student mathStudent = getStudent(deque, "Math");
        new MathRobot(mathStudent).start();
        deleteStudent(mathStudent);

      }

      if (hasStudent(deque, "Fizik")) {
        Student fizikStudent = getStudent(deque, "Fizik");
        new FizikRobot(fizikStudent).start();
        deleteStudent(fizikStudent);

      }

      if (hasStudent(deque, "OOP")) {
        Student OOPStudent = getStudent(deque, "OOP");
        new OOPRobot(getStudent(deque, "OOP")).start();
        deleteStudent(OOPStudent);
      }
    }

  }

}

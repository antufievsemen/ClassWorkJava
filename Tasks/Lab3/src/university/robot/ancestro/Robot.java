package university.robot.ancestro;

import generator.GeneratorOfStudents;
import lessons.Lesson;
import studentsqueue.ClassRoom;
import university.Student;

import java.util.concurrent.atomic.AtomicInteger;

public class Robot extends Thread {

  private static AtomicInteger n = new AtomicInteger(1);
  private Student student;
  protected Lesson lesson;
  private ClassRoom classRoom;
  private GeneratorOfStudents generator;

  public Robot(ClassRoom classRoom, GeneratorOfStudents generator) {
    this.classRoom = classRoom;
    this.generator = generator;
  }

  private Student getStudent() {
    return classRoom.queueOfStudents.peek();
  }

  private void setStudent(Student student) {
    this.student = student;
    classRoom.queueOfStudents.remove(student);
  }

  private void checkTasks() {
    try {
      Thread.sleep(student.getQuantOfTasks() * 5);
      System.out.println(n.getAndIncrement() + "Access " + Thread.currentThread().getName() + " + " + student.getLesson() + student.getQuantOfTasks());
    } catch (InterruptedException e) {
      System.out.println("CheckTask interrupt");
    }
  }

  @Override
  public void run() {
    while (generator.isAlive() || !classRoom.queueOfStudents.isEmpty()) {
      Student studentFirst = getStudent();
      if (studentFirst != null) {
        if (studentFirst.getLesson() == this.lesson) {
          setStudent(studentFirst);
          checkTasks();
        }
      }
    }
  }
}

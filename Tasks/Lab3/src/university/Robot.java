package university;

import studentsqueue.ClassRoom;

import java.util.concurrent.BlockingQueue;


public class Robot extends Thread {

  static int n = 1;
  private Student student;
  private boolean len = true;

  public boolean hasStudent(String lesson, BlockingQueue<Student> queue) {
    int countOfPeople = 0;
    for (Student student : queue) {
      if (student.getLesson().equals(lesson)) {
        return true;
      }
      if (countOfPeople++ == 9) {
        return false;
      }
    }
    return false;
  }

  public Student getStudent(String lesson, BlockingQueue<Student> queue) {
    for (Student student : queue) {
      if (student.getLesson().equals(lesson)) {
        return student;
      }
    }
    return null;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  private void checkTasks() {
    synchronized (this) {
      try {
          Thread.sleep(student.getQuantOfTasks() );
          System.out.println(n++ + "Access " + Thread.currentThread().getName() + " + " + Thread.currentThread().isAlive() + student.getLesson() + student.getQuantOfTasks());
      } catch (InterruptedException e) {
        System.out.println("HI");
        interrupt();
      }
    }
  }

  @Override
  public void run() {
    synchronized (Thread.currentThread()) {
      while (!ClassRoom.queueOfStudents.isEmpty()) {
        try {
          Thread.currentThread().wait();
            checkTasks();
        } catch (InterruptedException e) {
            Thread.yield();
            interrupt();
        }
      }
    }
  }
}

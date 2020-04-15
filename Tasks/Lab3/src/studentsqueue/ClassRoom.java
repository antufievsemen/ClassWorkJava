package studentsqueue;

import university.Student;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ClassRoom {
  public BlockingQueue<Student> queueOfStudents;

  public ClassRoom () {
    queueOfStudents = new LinkedBlockingQueue<>();
  }


}

package studentsqueue;

import university.Student;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ClassRoom {
  public static BlockingQueue<Student> queueOfStudents = new LinkedBlockingQueue<>();

}

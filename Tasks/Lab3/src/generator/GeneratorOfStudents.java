package generator;

import lessons.Lesson;
import studentsqueue.ClassRoom;
import university.Student;

import java.util.concurrent.ThreadLocalRandom;

public class GeneratorOfStudents extends Thread {
  private int countOfStudent;
  private ClassRoom classRoom;

  public GeneratorOfStudents(int count, ClassRoom classRoom) {
    countOfStudent = count;
    this.classRoom = classRoom;
    start();
  }

  private int generateCountOfLabs() {
    int number = Math.abs(ThreadLocalRandom.current().nextInt());
    switch (number % 3) {
      case 0:
        return 10;
      case 1:
        return 20;
      case 2:
        return 100;
    }

    return -1;
  }

  private Lesson generateSubjectName() {
    int number = Math.abs(ThreadLocalRandom.current().nextInt());
    switch (number % 3) {
      case 0:
        return Lesson.Fizik;
      case 1:
        return Lesson.Math;
      case 2:
        return Lesson.OOP;
    }

    return null;
  }

  private Student generateStudent() {
    return new Student(generateSubjectName(), generateCountOfLabs());
  }

  @Override
  public void run() {
    int i = 0;
    while(i++ <= countOfStudent) {
      try {
        Student student = generateStudent();
        classRoom.queueOfStudents.put(student);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}


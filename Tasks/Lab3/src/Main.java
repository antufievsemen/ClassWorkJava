import generator.GeneratorOfStudents;
import studentsqueue.ClassRoom;
import university.Robot;
import university.Student;

import static generator.GeneratorOfStudents.labsCount;
import static generator.GeneratorOfStudents.subjectName;


public class Main {


  public static void main(String[] args) {
    // subjectName = "Math";
    //labsCount = 10;
    new GeneratorOfStudents();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Robot MathRobot = new Robot();
    MathRobot.setName("Math");
    MathRobot.start();
    Robot OOPRobot = new Robot();
    OOPRobot.setName("OOP");
    OOPRobot.start();
    Robot FizikRobot = new Robot();
    FizikRobot.setName("Fizik");
    FizikRobot.start();
    while (!ClassRoom.queueOfStudents.isEmpty()) {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      if (MathRobot.hasStudent("Math", ClassRoom.queueOfStudents)) {
        Student studentTakeExams = MathRobot.getStudent("Math", ClassRoom.queueOfStudents);
        ClassRoom.queueOfStudents.remove(studentTakeExams);
        MathRobot.setStudent(studentTakeExams);
        synchronized (MathRobot) {
          MathRobot.notify();
        }
      }

      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      if (OOPRobot.hasStudent("OOP", ClassRoom.queueOfStudents)) {
        Student studentTakeExams = OOPRobot.getStudent("OOP", ClassRoom.queueOfStudents);
        ClassRoom.queueOfStudents.remove(studentTakeExams);
        OOPRobot.setStudent(studentTakeExams);
        synchronized (OOPRobot) {
          OOPRobot.notify();
        }
      }
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      if (FizikRobot.hasStudent("Fizik", ClassRoom.queueOfStudents)) {
        Student studentTakeExams = FizikRobot.getStudent("Fizik", ClassRoom.queueOfStudents);
        ClassRoom.queueOfStudents.remove(studentTakeExams);
        FizikRobot.setStudent(studentTakeExams);
        synchronized (FizikRobot) {
          FizikRobot.notify();
        }
      }
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }


    }
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    if (OOPRobot.isAlive()) {
      OOPRobot.interrupt();
    }
    if (FizikRobot.isAlive()) {
      FizikRobot.interrupt();
    }
    if (MathRobot.isAlive()) {
      MathRobot.interrupt();
    }


  }
}

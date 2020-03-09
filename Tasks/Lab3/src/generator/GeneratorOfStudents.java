package generator;

import studentsqueue.ClassRoom;
import university.Student;
import java.util.concurrent.ThreadLocalRandom;

public class GeneratorOfStudents extends Thread{

  public static int labsCount = 0;
  public static String subjectName = "";

  public GeneratorOfStudents(){
    start();
  }

  private int generateCountOfLabs(){
    int number = Math.abs(ThreadLocalRandom.current().nextInt());
    switch(number % 3){
      case 0 : return 10;
      case 1 : return 20;
      case 2 : return 100;
    }

    return -1;
  }

  private String generateSubjectName(){
    int number = Math.abs(ThreadLocalRandom.current().nextInt());
    switch(number % 3){
      case 0 : return "Fizik";
      case 1 : return "Math";
      case 2 : return "OOP";
    }

    return null;
  }

  public Student generateStudent(){
    if(labsCount == 0 && subjectName.equals("")) {
      return new Student(generateSubjectName(), generateCountOfLabs());
    }
    return new Student(subjectName, labsCount);
  }

  @Override
  public void run(){
   // while(!Thread.currentThread().isInterrupted()){
    while(ClassRoom.queueOfStudents.size() != 10){
      try {
        ClassRoom.queueOfStudents.put(generateStudent());
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    interrupt();
  }
}

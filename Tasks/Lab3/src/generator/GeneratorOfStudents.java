package generator;

import university.ClassRoom;
import university.Student;

import java.util.Random;

public class GeneratorOfStudents extends Thread{

  public static int labsCount = 0;
  public static String subjectName = "";

  private static int generateCountOfLabs(){

    Random intRandom = new Random();
    int number = Math.abs(intRandom.nextInt());
    if(number % 3 == 0){
      return 10;
    }

    if(number % 3 == 1){
      return 20;
    }

    if(number % 3 == 2){
      return 100;
    }

    return -1;
  }

  private static String generateSubjectName(){
    Random intRandom = new Random();
    int number = Math.abs(intRandom.nextInt());
    if(number % 3 == 0){
      return "Math";
    }

    if(number % 3 == 1){
      return "Fizik";
    }

    if(number % 3 == 2){
      return "OOP";
    }

    return null;
  }

  public static Student generateStudent(){
    if(labsCount == 0 && subjectName.equals("")){
      return new Student(generateSubjectName(), generateCountOfLabs());
    }
    return new Student(subjectName, labsCount);
  }

  @Override
  public void run(){
    while(ClassRoom.deque.size() != 20){
      ClassRoom.deque.addLast(generateStudent());
    }
  }
}

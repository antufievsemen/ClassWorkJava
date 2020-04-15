import generator.GeneratorOfStudents;

import studentsqueue.ClassRoom;
import university.robot.FizikRobot;
import university.robot.MathRobot;
import university.robot.OOPRobot;


public class Main {


  public static void main(String[] args) {
    ClassRoom classRoom = new ClassRoom();
    GeneratorOfStudents generator = new GeneratorOfStudents(20, classRoom);
    OOPRobot oopRobot = new OOPRobot(classRoom, generator);
    oopRobot.setName("OOP");
    FizikRobot fizikRobot = new FizikRobot(classRoom, generator);
    fizikRobot.setName("Fizik");
    MathRobot mathRobot = new MathRobot(classRoom, generator);
    mathRobot.setName("Math");
    oopRobot.start();
    fizikRobot.start();
    mathRobot.start();
  }
}

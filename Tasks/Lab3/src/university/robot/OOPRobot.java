package university.robot;

import generator.GeneratorOfStudents;
import lessons.Lesson;
import studentsqueue.ClassRoom;
import university.robot.ancestro.Robot;


public class OOPRobot extends Robot {

  public OOPRobot (ClassRoom classRoom, GeneratorOfStudents generator) {
    super(classRoom, generator);
    lesson = Lesson.OOP;
  }
}

package university.robot;

import generator.GeneratorOfStudents;
import lessons.Lesson;
import studentsqueue.ClassRoom;
import university.robot.ancestro.Robot;


public class MathRobot extends Robot {
  public MathRobot (ClassRoom classRoom, GeneratorOfStudents generator) {
    super(classRoom, generator);
    lesson = Lesson.Math;
  }
}

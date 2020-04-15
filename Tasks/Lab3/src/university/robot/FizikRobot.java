package university.robot;

import generator.GeneratorOfStudents;
import lessons.Lesson;
import studentsqueue.ClassRoom;
import university.robot.ancestro.Robot;


public class FizikRobot extends Robot {
  public FizikRobot(ClassRoom classRoom, GeneratorOfStudents generator) {
    super(classRoom, generator);
    lesson = Lesson.Fizik;
  }
}

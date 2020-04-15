package university;

import lessons.Lesson;

public class Student {

  private Lesson lesson;
  private int quantOfTasks;

  public Student(Lesson lesson, int quantOfTasks){
    this.lesson = lesson;
    this.quantOfTasks = quantOfTasks;
  }

  public int getQuantOfTasks() {
    return quantOfTasks;
  }

  public Lesson getLesson() {
    return lesson;
  }

}

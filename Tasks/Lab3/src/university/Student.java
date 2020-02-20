package university;

public class Student {

  private String lesson;
  private int quantOfTasks;

  public Student(String lesson, int quantOfTasks){
    this.lesson = lesson;
    this.quantOfTasks = quantOfTasks;
  }

  public int getQuantOfTasks() {
    return quantOfTasks;
  }

  public String getLesson() {
    return lesson;
  }

}

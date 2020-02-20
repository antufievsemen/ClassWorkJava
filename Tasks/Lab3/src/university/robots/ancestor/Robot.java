package university.robots.ancestor;

import university.Student;

public class Robot extends Thread {

  private Student student;

  public Robot(Student student){
    this.student = student;
  }

  private synchronized void checkTask(){

    try{
      Thread.sleep(student.getQuantOfTasks() / 5 * 500);
      System.out.println("Student access " + student.getLesson() + student.getQuantOfTasks());
    } catch (InterruptedException e){
      System.out.printf("Interrupted %s", getName());
    }

  }

  @Override
  public void run(){
    checkTask();
  }

}

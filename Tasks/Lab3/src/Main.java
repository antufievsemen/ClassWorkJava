import generator.GeneratorOfStudents;
import university.ClassRoom;

public class Main {
  public static void main(String[] args){
    ClassRoom classRoom = new ClassRoom();

    GeneratorOfStudents.subjectName = "";
    GeneratorOfStudents.labsCount = 0;
    GeneratorOfStudents generator = new GeneratorOfStudents();
    ClassRoom.deque.addLast(GeneratorOfStudents.generateStudent());
    ClassRoom.deque.addLast(GeneratorOfStudents.generateStudent());
    ClassRoom.deque.addLast(GeneratorOfStudents.generateStudent());
    ClassRoom.deque.addLast(GeneratorOfStudents.generateStudent());
    ClassRoom.deque.addLast(GeneratorOfStudents.generateStudent());
    ClassRoom.deque.addLast(GeneratorOfStudents.generateStudent());
    ClassRoom.deque.addLast(GeneratorOfStudents.generateStudent());
    ClassRoom.deque.addLast(GeneratorOfStudents.generateStudent());
    ClassRoom.deque.addLast(GeneratorOfStudents.generateStudent());
    ClassRoom.deque.addLast(GeneratorOfStudents.generateStudent());
    generator.start();
    classRoom.start();
  }
}

import java.util.Scanner;

public class Main {
  public static void main(String []arg){
    System.out.println("Enter numbers a and b");
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    if(a > b){
      int swap;
      swap = b;
      b = a;
      a = swap;
    }

    for(int i = a; i <= b; ++i){
      System.out.print(i + " ");
    }
  }
}

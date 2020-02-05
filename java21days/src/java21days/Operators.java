package java21days;

public class Operators {
  public static void main(String[] arguments) {
    int x, y, z;
    x = 42;
    System.out.println("x = " + x);
    y = x++;
    System.out.println("x after y = " + x);
    System.out.println("y = " + y);
    
    z = ++x;
    System.out.println("x after z= " + x);
    System.out.println("z = " + z);
  }
}

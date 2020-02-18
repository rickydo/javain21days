// package java21days;
// // Java 9 introduces private methods and private static method in interfaces
// // can have constant variables, abstract methods, default methods, static methods, private methods, private static methods

// public interface TempI {
//   public abstract void mul(int a, int b);

//   public default void
//     add(int a, int b) {
//       // private mthod inside default mthod
//       sub(a, b);

//       // static method inside other non static method
//       div(a,b);
//       System.out.print("Answer by Default Method = ");
//       System.out.println(a + b);

//       public static void mod(int a, int b) {
//         div(a,b); //static method inside other static method
//         System.out.print("Answer by Static method = ");
//         System.out.println(a % b);
//       }

//       private void sub(int a, int b) {
//         System.out.print("Answer by Private method = ");
//         System.out.println(a - b);
//       }

//       private static void div(int a, int b) {
//         System.out.print("Answer by Private Static method = "));
//         System.out.println(a / b);
//     }
    
// }

// class Temp implement TempI {
//   @Override
//   public void mul(int a, int b) {
//     System.out.print("Answer by Abstract method = ");
//     System.out.println(a * b);

//   }

//   public static void main(String[] args) {
//     TempI in = new Temp();
//     in.mul(2,3);
//     in.add(6,2);
//     TempI.mod(5,3);
//   }
// }
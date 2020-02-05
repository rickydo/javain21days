package java21days;

public class Weather {
  public static void main(String[] arguments) {
    float fah = 86;
    System.out.println(fah + " degrees Fahrenheit is ...");

    fah = (fah - 32) / 9 * 5;
    System.out.println(fah + " degrees Celsius\n");

    float cel = 33;
    System.out.println(cel + " degrees Celsius is ...");

    cel = ( cel * 9 ) / 5 + 32;
    System.out.println(cel + " degrees Fahrenheit");;
  }
}
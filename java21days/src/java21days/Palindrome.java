package java21days;

class Palindrome {
  String reversedStr;
  String input;
  int arLen;

  public Palindrome (String inInput) {
    input = inInput;
    arLen = inInput.length() - 1;
  }

  public static void main(String[] args) {
    Palindrome pd = new Palindrome(args[0]);
    pd.reverseString();
    pd.isPalindrome();
  }

  public void reverseString() {
    if (arLen > 0) {
      System.out.println("My input is: " + input);
      StringBuilder sb = new StringBuilder();
      for (int i = arLen; i >= 0; i--) {
        System.out.println("my char at " + i + ": " + input.charAt(i));
        sb.append(input.charAt(i));
      }
      reversedStr = sb.toString();
      System.out.println("My computed reversed string: " + reversedStr);
    } else {
      System.out.println("Input is required");
    }
  }

  public void isPalindrome() {
    System.out.println("The input: " + input);
    System.out.println("The reversed input string: " + reversedStr);
    if (reversedStr.equals(input)) {
      System.out.println("the string is a palindrome!");
    } else {
      System.out.println("the string is NOT a palindrome!");
    }
  }
}
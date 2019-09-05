package Lecture3;

// TestBreak.java: Test the break keyword in the loop
public class TestBreak {

  /**Main method*/

  public static void main(String[] args)   {
    int sum = 0;
    int item = 0;

    while (item < 5)  {
      item ++;
      sum += item;
      if (sum >=6) break;
    }

    System.out.println("The sum is " + sum);
  }
}

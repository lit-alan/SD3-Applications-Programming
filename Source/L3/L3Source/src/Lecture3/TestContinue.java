package Lecture3;

//Test the continue keyword in Java

public class TestContinue {
 
  /**Main method*/
  public static void main(String[] args)   {
    int sum = 0;
    int item = 0;

    while (item < 5) {
      item++;
      if (item == 2) continue;
      sum += item;
    }// End While

    System.out.println("The sum is " + sum);

  }// End Main

}//End Class TestContinue

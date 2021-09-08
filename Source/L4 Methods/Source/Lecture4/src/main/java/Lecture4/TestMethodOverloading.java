package Lecture4;


/*
 *Demonstrate method overloading my including methods of the same name, but with
 *different signatures within the same class. Its the job of the compiler to find
 *the correct method based on the class.
 */

public class TestMethodOverloading {

  /**Main method*/
  public static void main(String[] args)   {
    // Invoke the max method with int parameters
   System.out.println("The maximum between 3 and 4 is " + max(3, 4));

    // Invoke the max method with the double parameters
    System.out.println("The maximum between 3.0 and 5.4 is " + max(3.0, 5.4));

    // Invoke the max method with three double parameters
    System.out.println("The maximum between 3.0, 5.4, and 10.14 is " + max(3.0, 5.4, 10.14));

    // Invoke the max method with four double
     System.out.println("The maximum between 3.0, 5.4, 10.14 and 78.7 is " + max(3.0, 5.4, 10.14, 78.7));

     // Invoke the max method with five double parameters
     System.out.println("The maximum between 3.0, 5.4, 10.14, 78.7 and 65.2 is " + max(3.0, 5.4, 10.14, 78.7, 62.2));

  } // End Main

  /**Find the max between two int values*/
  static int max(int num1, int num2) {
  	System.out.println("Max1");
    if (num1 > num2)
      return num1;
    else
      return num2;
  }// End Max(int,int): int

  /**Find the max between two double values*/
  static double max(double num1, double num2)  {
    if (num1 > num2)
      return num1;
    else
      return num2;
  }// End Max(double, double): double

  /**Find the max among three double values*/
  static double max(double num1, double num2, double num3) {
    return max(max(num1, num2), num3);
  }// End Max(double, double, double): double

    /**Find the max among four double values*/
  static double max(double num1, double num2, double num3, double num4) {
    return max(num4,max(max(num1, num2), num3));
  }// End Max(double, double,double, double): double

  /**Find the max among five double values*/
  static double max(double num1, double num2, double num3, double num4, double num5) {
    return max(num5,(max(num4,max(max(num1, num2), num3))));
  }// End Max(double, double,double, double): double

}//End Class TestMethodOverLoading
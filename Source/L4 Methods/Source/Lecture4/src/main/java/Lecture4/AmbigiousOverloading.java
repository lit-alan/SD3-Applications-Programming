package Lecture4;

/**
 *
 * @author Alan.Ryan
 */
public class AmbigiousOverloading {

    public static void main(String args[]) {
     //  System.out.println(max(1, 2)); uncomment this line to see a  example of Ambigious Overloading
    }

    public double max(int num1, double num2) {
        if (num1 > num2) {
            return num1;
        } else {
            return num2;
        }
    }

    public int max(double num1, int num2) {
        if (num1 > num2) {
            return (int)num1;
        } else {
            return num2;
        }
    }

}//end class

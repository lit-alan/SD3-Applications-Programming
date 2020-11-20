package Lecture4;

/**
 *
 * @author Alan.Ryan
 */
public class AmbigiousOverloading {

    public static void main(String args[]) {
        System.out.println(max(1, 2));
    }//end main

    public double max(int num1, double num2) {
        if (num1 > num2) {
            return num1;
        } else {
            return num2;
        }
    }//end max(int,double)

    public double max(double num1, int num2) {
        if (num1 > num2) {
            return num1;
        } else {
            return num2;
        }
    }//end max(double,int)

}//end class

package Lecture4;

/**
 *
 * @author Alan.Ryan
 */
public class TestMax {
    
    public static void main(String[] args) {
        int i = 5;
        int j = 2;
        int k = max(i, j);
        System.out.println("The larger of the numbers " + i + " and " + j + " is " + k);

    }//end main

    static int max(int num1, int num2) {
        if (num1 > num2) {
            return num1;
        } else {
            return num2;
        }
    }//end max		

}//end class
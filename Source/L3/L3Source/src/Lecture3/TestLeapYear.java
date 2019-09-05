package Lecture3;

/**
 *
 * @author Alan.Ryan
 */
public class TestLeapYear {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int y = 2012;
        
        if (y % 4 == 0 && (y % 100 != 0 || y % 400 == 0)) {
            System.out.println(y  + " IS a leap year");
        }
        else {
            System.out.println(y + " is NOT a leap year");
        }
    }
    
}

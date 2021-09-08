package Lecture3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alan.Ryan
 */
public class TestForEach {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int values[] = {2, 4, 6};
        
        for (int x : values) {
            System.out.print(x + " ");
        }
        
        System.out.println("");
        
        ArrayList<String> wiseMen = new ArrayList();
        wiseMen.add("Alan");
        wiseMen.add("Brendan");
        wiseMen.add("Gerry");

        for (String item : wiseMen) {
            System.out.println(item);
        }
    }
    
}

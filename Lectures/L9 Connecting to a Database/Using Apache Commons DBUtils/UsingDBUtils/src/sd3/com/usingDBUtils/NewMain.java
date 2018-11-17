/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd3.com.usingDBUtils;

/**
 *
 * @author alan.ryan
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        final int x = 2;
        
        for(int z=1; z < 10; z++ ) {
            switch(z) {
                case x: System.out.print("A ");
                case x-1: System.out.print("B ");
                case x-2: System.out.print("C ");
                default : System.out.print("D ");
            }
        }
       
    }
    
}

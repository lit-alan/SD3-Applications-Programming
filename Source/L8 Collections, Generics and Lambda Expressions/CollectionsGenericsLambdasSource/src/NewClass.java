
import java.util.ArrayList;
import javax.swing.JButton;


public class NewClass {
    
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList(3);
        
        myList.add("Alan");
        myList.add("Des");
        myList.add("Carol");
        myList.add("Liz");
//        myList.add(new Integer(2));
//        myList.add(new JButton("Click ME!"));
        
//        for (Object o : myList) {
//            String s = (String) o;
//            System.out.println(s);
//        }
//        

        for (String s : myList) {
            String aString = s;
            System.out.println(aString);
        }
        
        
        
    }
}

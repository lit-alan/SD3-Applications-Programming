package sd3.com.concurrency;

import java.util.List;
import sd3.com.CA.model.Name;

public class Print implements Runnable {
    List<Name> list;
    String name;

    public Print(List<Name> list, String name) {
        this.list = list;
        this.name = name;
    }
    
    @Override
    public void run() {
        int counter = 0;
        for (Name n : list) {
            if(n.getName().equalsIgnoreCase(name)) {
                System.out.println(n.getName() + "\t" + n.getYear() + "\t" + n.getOccurrences());
                counter++;
            }
           
        }
     System.out.println(name + " was found " + counter + " times");
    }
}
package sd3.com.concurrency;

import java.util.List;
import java.util.concurrent.Callable;
import sd3.com.CA.model.Name;

public class Search implements Callable<Double> {

    List<Name> list;
    String name;
    int y1;
    int y2;

    public Search(List<Name> list, String name, int y1, int y2) {
        this.name = name;
        this.list = list;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public Double call() throws Exception {
        int totals[] = new int[2];
        
        for (Name aName : list) {
            if (aName.getYear() == y1 && aName.getName().equalsIgnoreCase(name)) {
               totals[0] = aName.getOccurrences();
            }
            if (aName.getYear() == y2 && aName.getName().equalsIgnoreCase(name)) {
                totals[1] = aName.getOccurrences();
            }
        }

        int diff = totals[0] - totals[1];
        return  (double) diff/totals[0];
        
        
            
    }

}

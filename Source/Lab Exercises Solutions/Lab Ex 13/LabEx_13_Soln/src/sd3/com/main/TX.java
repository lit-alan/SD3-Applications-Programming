package sd3.com.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import sd3.com.io.FileIO;
import sd3.com.model.Name;

public class TX {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        List<Name> list = FileIO.parseFile("TX.txt");

        ExecutorService exe = Executors.newCachedThreadPool();
        Future<List<Name>> f1 = exe.submit(new SearchTexas(list, "Dallas", 3.757, 6.245));
        f1.get().forEach(System.out::println);

        exe.submit(new PrintTexas("alva", list));


        exe.shutdown();
    }

   

}

class PrintTexas implements Runnable {

    private final String prefix;
    private final List<Name> list;

    public PrintTexas(String prefix, List<Name> list) {
        this.prefix = prefix;
        this.list = list;
    }

    @Override
    public void run() {
        for (Name name : list) {
            if (name.getName().toLowerCase().startsWith(prefix.toLowerCase())) {
                System.out.printf("%-20s%-6d\n", name.getName(),name.getRank());
            }
        }
    }
}

class SearchTexas implements Callable<List<Name>> {
    
    List<Name> list;
    String city;
    double lowerBound;
    double upperBound;

    public SearchTexas(List<Name> list, String city, double lowerBound, double upperBound) {
        this.list = list;
        this.city = city;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public List<Name> call() throws Exception {

        List<Name> filterdList = new ArrayList();

        for (Name name : list) {
            if (name.getCumulativeFrequency() >= lowerBound && name.getCumulativeFrequency() <= upperBound && name.getCity().equals(city)) {
                filterdList.add(name);
            }
        }
        return filterdList;

//    return  list.stream()
//                .filter(n -> n.getCumulativeFrequency() >= lowerBound && n.getCumulativeFrequency() <= upperBound && n.getCity().equals(city))
//                .sorted(Comparator.comparing(Name::getName)) //the names are sorted alphabetically so this step is superfluous
//                .collect(Collectors.toList()); //convert the stream to a list
    }
}

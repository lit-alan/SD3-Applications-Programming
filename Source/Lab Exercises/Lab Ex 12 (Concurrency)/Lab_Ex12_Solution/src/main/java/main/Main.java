package main;

import java.text.NumberFormat;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import IO.FileIO;
import model.Name;


public class Main {

    static NumberFormat nf = NumberFormat.getPercentInstance();

    public static void main(String[] args) {

        List<Name> list = FileIO.parseFile("CA.txt");

        ExecutorService exe = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledexe = Executors.newScheduledThreadPool(1);
        Future<Double> f1 = exe.submit(new Search(list, "Paul", 2000, 2017));

        nf.setMaximumFractionDigits(2);

        try {
            System.out.println("Percentage Diff " + nf.format(f1.get()));
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println(ex);
        }

        exe.submit(new PrintNameOccurances(list, "Mary"));
        
        int delay = 3;
        int period = 5;
        scheduledexe.scheduleAtFixedRate(new PrintPopularName(list), delay, period, TimeUnit.SECONDS);
      
       // scheduledexe.shutdown();
        exe.shutdown();
      

    }
}

////////////////////////////////////////////////////////////////

class Search implements Callable<Double> {

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
        int tot1 = 0, tot2 = 0;

        for (Name aName : list) {
            if (aName.getYear() == y1
                    && aName.getName().equalsIgnoreCase(name)) {
                tot1 = aName.getOccurrences();
            }
            if (aName.getYear() == y2
                    && aName.getName().equalsIgnoreCase(name)) {
                tot2= aName.getOccurrences();
            }
        }

        int diff = tot1 - tot2;
        return (double) diff / tot1;

    }
}

////////////////////////////////////////////////////////////////
class PrintNameOccurances implements Runnable {

    List<Name> list;
    String name;

    public PrintNameOccurances(List<Name> list, String name) {
        this.list = list;
        this.name = name;
    }

    @Override
    public void run() {
        int counter = 0;
        for (Name n : list) {
            if (n.getName().equalsIgnoreCase(name)) {
                System.out.println(n.getName() + "\t" + n.getYear() + "\t" + n.getOccurrences());
                counter++;
            }

        }
        System.out.println(name + " was found " + counter + " times");
    }
}

////////////////////////////////////////////////////////////////

class PrintPopularName implements Runnable {

    List<Name> list;
    

    public PrintPopularName(List<Name> list) {

        this.list = list;
    }

    @Override
    public void run() {
        int randomYear = ThreadLocalRandom.current().nextInt(1910, 2017 + 1);
        
        list.stream().filter((n) -> n.getYear() == randomYear && n.getGender().equals("F"))
                                       .findFirst()
                                       .ifPresent(System.out::println);

//        for (Name n : list) {
//            if (n.getYear() == randomYear && n.getGender().equals("F")) {
//                System.out.println(n);
//
//                break;
//            }
//        }
//           

      list.stream().filter((n) -> n.getYear() == randomYear && n.getGender().equals("M"))
                                       .findFirst()
                                      .ifPresent(System.out::println);
    }//end run

}//end class

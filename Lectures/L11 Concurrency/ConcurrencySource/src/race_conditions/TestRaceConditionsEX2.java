package race_conditions;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestRaceConditionsEX2 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        Counter counter = new Counter();

        Runnable t1 = () -> { counter.add(1); };
        Runnable t2 = () -> { counter.add(2); };
        Runnable t3 = () -> { counter.add(3); };
        Runnable t4 = () -> { counter.add(4); };
        Runnable t5 = () -> { counter.add(5); };

        executor.submit(t1);
        executor.submit(t2);
        executor.submit(t3);
        executor.submit(t4);
        executor.submit(t5);

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.MINUTES);
        System.out.println("Final Value:" + counter.getCount());

    }//end main
}

class Counter {

    protected int count = 0;

    public void  add(int value) {
        
       synchronized(this) {
            this.count = this.count + value;
       }
    }

    public int getCount() {
        return count;
    }

}//end Counter class

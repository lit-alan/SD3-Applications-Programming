package src.version2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LabEx_Ten {

    static final int LIMIT = 1000;

    static int[] numbers = {1, 1 , 4, 2, 1, 1, 1, 6, 7, 1, 1, 7, 1, 1};

    public static void main(String[] args) throws InterruptedException, ExecutionException {

//        If you want to randomly generate values for the array        
//        for (int i = 0; i < LIMIT; i++) {
//            numbers[i] = ThreadLocalRandom.current().nextInt(1, 10 + 1);
//        }
 
        OddTask oddTask = new OddTask(numbers);
        EvenTask evenTask = new EvenTask(numbers);
        PrintList printList = new PrintList(numbers);

        ExecutorService exe = Executors.newCachedThreadPool();
        Future<Integer> f1 = exe.submit(oddTask);
        Future<Integer> f2 = exe.submit(evenTask);
        
        exe.submit(printList);
        
        System.err.println("Odd Count " + f1.get());
        System.err.println("EvenCount " + f2.get());
        
        exe.shutdown();

  
    }
}

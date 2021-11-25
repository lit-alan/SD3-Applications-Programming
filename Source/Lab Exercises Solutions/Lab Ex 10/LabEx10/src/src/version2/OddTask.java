package src.version2;

import java.util.concurrent.Callable;

/**
 *
 * @author Alan.Ryan
 */
public class OddTask  implements Callable<Integer>{

    int numbers[];

    public OddTask(int[] numbers) {
        this.numbers = numbers;
    }
    
    
    @Override
    public Integer call() throws Exception {
        int oddCount = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] % 2 != 0) {
                    oddCount++;
                }
            }
            return oddCount;
            
    }
    
}

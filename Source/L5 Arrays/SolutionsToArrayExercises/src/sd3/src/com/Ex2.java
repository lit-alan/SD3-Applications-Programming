package sd3.src.com;

import java.util.concurrent.ThreadLocalRandom;

public class Ex2 {

    public static void main(String[] args) {
        int rands[] = new int[5000];
        int frequency[] = new int[30];
        int min = 0;
        int max = 29;
        int randomValue = 0;
        int modal = 0;
        int value = 0;
       
        //init array with random values in range 
        for (int i = 0; i < rands.length; i++) {
            randomValue = ThreadLocalRandom.current().nextInt(min, max + 1);
            rands[i] = randomValue;
            frequency[randomValue]++;
        }

        System.out.println("Frequency Distribution Table");
        for (int i = 0; i < frequency.length; i++) {
            System.out.println(i + " occured " + frequency[i] + " times");
        }
        
        value = frequency[0];
        
        for (int i = 1; i < frequency.length; i++) {            
            if (frequency[i] > value) {
                modal = i;
                value = frequency[i];
            }
        }
        
        System.out.println("\n\nModal value is " + modal + " as it occured " + value + " times");
    }
}
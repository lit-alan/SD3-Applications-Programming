package src.version2;

public class PrintList implements Runnable {

    int numbers[];

    public PrintList() {
    }

    public PrintList(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        for (int i = 0; i < numbers.length; i++) {

            System.out.print(numbers[i] + " ");

            while (numbers[i] == 1) {

                int n = numbers[i + 1];

                if (n != 1) {
                    System.out.print(n + " ");
                }

                i++;
            }//end while

        }//end for

    }

}

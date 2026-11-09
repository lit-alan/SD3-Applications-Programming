package thread_basics;

public class TestFunctional {

    public static void main(String[] args) {

        Runnable goodbye = () -> {
            for (int i = 1; i <= 100; i++) {
                    System.out.println("Goodbye " + i);
                }
        };

        Runnable hello = () -> {
            for (int i = 1; i <= 100; i++) {
                System.out.println("Hello " + i);
            }

        };

        Thread t1 = new Thread(goodbye);
        Thread t2 = new Thread(hello);
        t1.start();
        t2.start();
        System.out.println("done!");
    }//end main

}//end class
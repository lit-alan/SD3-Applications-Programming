package thread_basics;

// TestRunnable.java: Define threads using the Runnable interface
public class TestRunnable {

    /**
     * Main method
     */
    public static void main(String[] args) {
        new TestRunnable();
    }

    public TestRunnable() {
        // Create threads
        Thread t1 = new Thread(new HelloThread());
        Thread t2 = new Thread(new GoodByeThread());

        //Start threads
        t1.start();
        t2.start();
        
        System.out.println("done!");

    }

////////////////////////////////////////////////////////////////////////////////////
// The thread class for printing "Hello" 100 times
    class HelloThread implements Runnable {

        final String MESSAGE = "Hello";
        final int COUNT = 100;

        //tell the system what the thread will do in run()
        public void run() {
            for (int i = 1; i <= COUNT; i++) {
                System.out.println(MESSAGE + i);
            }
        }//end run
    }//end class HelloThread

////////////////////////////////////////////////////////////////////////////////////
// The thread class for printing "Goodbye" 100 times
    class GoodByeThread implements Runnable {

        final String MESSAGE = "Goodbye";
        final int COUNT = 100;

        //tell the system what the thread will do in run()
        public void run() {
            for (int i = 1; i <= COUNT; i++) {
                System.out.println(MESSAGE + i);
            }
        }//end run

    }//end class GoodByeThread
}//end class TestRunnable

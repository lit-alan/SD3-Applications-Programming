package thread_basics;

//A class to create three threads, assign them a priority and then run them
public class TestThread {

  /**Main method*/
  public static void main(String[] args) {

    // Create threads
//    HelloThread t1 = new HelloThread();
//    GoodByeThread t2 = new GoodByeThread();
//

    PrintMessageThread t1 = new PrintMessageThread("Hello World", 1000);
    PrintMessageThread t2 = new PrintMessageThread("GoodBye World", 500);
    // Start threads
    t1.start();
    t2.start();

    System.out.println("done!");
  }//end main
}//end class Test Thread

////////////////////////////////////////////////////////////////////////////////////
// The thread class for printing "Hello" 100 times
class HelloThread extends Thread {

    final String MESSAGE = "Hello";
    final int COUNT = 100;

  //tell the system what the thread will do in run()
  public void run() {
    for (int i=1; i<=COUNT; i++)
      System.out.println(MESSAGE + i);
  }//end run
}//end class HelloThread

////////////////////////////////////////////////////////////////////////////////////
// The thread class for printing "Goodbye" 100 times
class GoodByeThread extends Thread {

  final String MESSAGE = "Goodbye";
  final int COUNT = 100;


  //tell the system what the thread will do in run()
  public void run() {
    for (int i=1; i <= COUNT; i++)
      System.out.println(MESSAGE + i);
  }//end run

}//end class GoodByeThread


class PrintMessageThread extends Thread {

  String MESSAGE = "";
  int COUNT = 0;

  public PrintMessageThread(String message, int count) {
    this.MESSAGE = message;
    this.COUNT = count;
  }

  //tell the system what the thread will do in run()
  public void run() {
    for (int i=1; i <= COUNT; i++)
      System.out.println(MESSAGE + i);
  }//end run

}//end class
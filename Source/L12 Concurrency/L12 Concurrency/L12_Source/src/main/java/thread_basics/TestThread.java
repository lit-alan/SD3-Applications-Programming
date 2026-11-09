package thread_basics;

//A class to create three threads, assign them a priority and then run them
public class TestThread {

  /**Main method*/
  public static void main(String[] args) throws InterruptedException {

    // Create threads
//    HelloThread t1 = new HelloThread();
//    GoodByeThread t2 = new GoodByeThread();
//

    PrintMessageThread t1 = new PrintMessageThread("Hello World ", 100);
    PrintMessageThread t2 = new PrintMessageThread("GoodBye World ", 100);
    // Start threads
    t1.start();
    t2.start();

    t1.join();
    t2.join();


    System.out.println("done!");
  }//end main
}//end class Test Thread

////////////////////////////////////////////////////////////////////////////////////
// The thread class for printing "Hello" 100 times
class HelloThread extends Thread {

    final String message = "Hello";
    final int count = 100;

  //tell the system what the thread will do in run()
  public void run() {
    for (int i = 1; i<= count; i++)
      System.out.println(message + i);
  }//end run
}//end class HelloThread

////////////////////////////////////////////////////////////////////////////////////
// The thread class for printing "Goodbye" 100 times
class GoodByeThread extends Thread {

  final String message = "Goodbye";
  final int count = 100;


  //tell the system what the thread will do in run()
  public void run() {
    for (int i = 1; i <= count; i++)
      System.out.println(message + i);
  }//end run

}//end class GoodByeThread


class PrintMessageThread extends Thread {

  String message = "";
  int count = 0;

  public PrintMessageThread(String message, int count) {
    this.message = message;
    this.count = count;
  }

  //tell the system what the thread will do in run()
  public  void run() {
    for (int i = 1; i <= count; i++)
      System.out.println(message + i);
  }//end run

}//end class
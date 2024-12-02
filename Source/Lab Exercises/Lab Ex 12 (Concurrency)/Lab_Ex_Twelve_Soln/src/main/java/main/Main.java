package main;

import io.FileIO;
import model.Customer;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


/**
 *
 * @author Alan.Ryan Customer Personality Analysis is a detailed analysis of a
 * company’s ideal customers. It helps a business to better understand its
 * customers and makes it easier for them to modify products according to the
 * specific needs, behaviors and concerns of different types of customers.
 * Customer personality analysis helps a business to modify its product based on
 * its target customers from different types of customer segments. For example,
 * instead of spending money to market a new product to every customer in the
 * company’s database, a company can analyze which customer segment is most
 * likely to buy the product and then market the product only on that particular
 * segment.
 */
public class Main {

    public static void main(String[] args) {

        List<Customer> customerList = FileIO.readFile("marketing_campaign.txt");
        System.out.println(customerList.size() + " records found");

        ScheduledExecutorService scheduledexe = Executors.newScheduledThreadPool(1);
        ExecutorService exe = Executors.newCachedThreadPool();

        //task one
        Future<Customer> f = exe.submit(new LargestRecency(customerList));
        try {
            System.out.println(f.get());
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println(ex);
        }

        //task two
        exe.submit(new PrintMedianIncome(customerList, "Masters"));

        //task three
        int delay = 0;
        int period = 3;
        scheduledexe.scheduleAtFixedRate(new PrintCustomerSpend(customerList), delay, period, TimeUnit.SECONDS);

        exe.shutdown();

    }

}

//Task One
class LargestRecency implements Callable<Customer> {

    List<Customer> list;

    public LargestRecency(List<Customer> list) {
        this.list = list;
    }

    @Override
    public Customer call() throws Exception {

        return list.stream()  // Convert list to stream
                .filter(Customer::isComplained)  // Keep only customers who have complained
                .max(Comparator.comparingInt(Customer::getRecency))  // Find the maximum by recency
                .orElse(null);  // Return null if no such customer is found


        //alternatively
//       Customer c = null;
//        int largestRecency = 0;
//        for (Customer customer : list) {
//            if (customer.isComplained() && customer.getRecency() > largestRecency) {
//                largestRecency=customer.getRecency();
//                c = customer;
//            }
//        }
//        return c;


    }//end call
}

//Task Two
class PrintMedianIncome implements Runnable {
    List<Customer> list;
    String qualification;
    NumberFormat nf = NumberFormat.getCurrencyInstance();

    public PrintMedianIncome(List<Customer> list, String qualification) {
        this.list = list;
        this.qualification = qualification;
    }


    @Override
    public void run() {

        //stream the list
        List<Double> incomes = list.stream()
                .filter(customer -> qualification.equals(customer.getEducation()))  //filter by qualification
                .map(Customer::getIncome)   //grab the incomes after filtering
                .sorted()  //sort the cincomes
                .collect(Collectors.toList());  //collect them into a list



/*
        //A more traditional approach

        // Create a new list to store filtered incomes
        List<Double> incomes = new ArrayList();

        //Filter customers based on qualification and collect their incomes
        for (Customer customer : list) {
            if (qualification.equals(customer.getEducation())) {
                incomes.add(customer.getIncome());
            }
        }

        //Sort the incomes
        Collections.sort(incomes);
*/
        //Calculate the median income
        double medianIncome = incomes.get(incomes.size() / 2);

        //format and print the result
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        System.out.println("Median income of those with an educational level of " + qualification + " is " + nf.format(medianIncome));


    }


}

//Task Three
class PrintCustomerSpend implements Runnable {

    List<Customer> list;

    public PrintCustomerSpend(List<Customer> list) {
        this.list = list;
    }

    @Override
    public void run() {

        //generate a random customer ID within the range 0 to 11191
        int randomId = ThreadLocalRandom.current().nextInt(0, 11192);

        //get a number formatter for percentages
        NumberFormat percentageFormat = NumberFormat.getPercentInstance();
        percentageFormat.setMinimumFractionDigits(5);

        //find the customer with the generated ID
        Customer customer = list.stream()
                .filter(cust -> cust.getId() == randomId)
                .findAny()
                .orElse(null);


  /*
        //Find the customer with the generated ID without using streams
        Customer customer = null;
        for (Customer cust : list) {
            if (cust.getId() == randomId) {
                customer = cust;
                //Exit the loop as soon as the customer is found
                break;
            }
        }
*/

        //Display the result
        if (customer == null) {
            System.out.println("No record found with an ID of " + randomId + "\n");
        } else {
            //Avoid division by zero
            double income = customer.getIncome();
            if (income > 0) {
                double percentageSpentOnWine = customer.getAmtWines() / income;
                System.out.println("% of income spent on wine: " +
                                    percentageFormat.format(percentageSpentOnWine) +
                                    " for ID: " + customer.getId() + "\n");
            } else {
                System.out.println("Income is zero or invalid for ID: " + customer.getId() + ". Cannot calculate percentage.\n");
            }
        }
    }

}//end class Print

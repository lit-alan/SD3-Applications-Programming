# Lab Exercise 3 - Introduction to OOP :punch:

Open the project _“FutureInvestmentsStarter”_. This project contains two classes (in a package called `sd3.app_prog.ui`):

`Console` – This class is used for input/output from/to the console. You will not need to make any
changes to this class.

`Main` – This is the main/driver class for the application. When you run this application, it will
continually prompt you to enter a monthly investment amount, yearly interest rate and a number of
years (that the amount will be invested for). The user can signal their intent to stop entering data
(investments) at the prompt.

You must add another class (called `Investment` to the project). Add this class to the
`sd3.app_prog.model` package in the project. <br>

Add the following three (private) instance variables to this class:

• monthlyInvestment (a double)

• yearlyInterestRate (a double)

• years (an int).

<br>
You must add appropriate getters/setters for these three instance variables to the `Investment` class.

You must also add **two constructors** to this class:


• The first must be the default (no-args) constructor and will initialise the three instance
variables their default variables.

• The second constructor will accept values for a monthly investment, a yearly interest rate
and a number of years (this is the all-args constructor). You must use these values to initialise the instance variables for a
given investment object.

You must finally add the following utility method to the `Investment` class.


```java
public double calculateFutureValue() {

    //convert yearly values to monthly values
    double monthlyInterestRate = yearlyInterestRate / 12 / 100;
    int months = years * 12;

    //calculate the future value
    double futureValue = 0;

    for (int i = 1; i <= months; i++) {
        futureValue += monthlyInvestment;

        double monthlyInterestAmount =
                futureValue * monthlyInterestRate;

        futureValue += monthlyInterestAmount;
    }

    return futureValue;
}
```

This method will calculate and return (as a double) the future value of a given investment.

You may (if you wish) override the `toString()` method in the class as it could prove useful

To Do 📝

In the `Main` class:

- [ ] Create an array with 5 elements. This array will store `Investment` objects.
- [ ] Create five `Investment` objects and add them to the array. The user must enter the data for these
objects via the keyboard. Test data appears on the next page.
- [ ] Output the details of the five investment objects along with their future value.
- [ ] Increase the interest rate for each investment object by 2% and again display the details of the
five investment objects (including their new future value).
- [ ] Display only those investment objects which have a future value greater than €25,000.

All input/output should be achieved using the various static methods of the `Console` class (which I
have provided). Ensure that the appearance of any monetary and percentage values in your output is formatted
appropriately (the [NumberFormat](https://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html) class should help with this).

<img width="495" height="871" alt="image" src="https://github.com/user-attachments/assets/95243af3-d314-4538-82f5-fd9bb94b7bfd" />

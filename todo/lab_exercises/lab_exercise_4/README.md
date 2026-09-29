# Lab Exercise 4️⃣ - Inheritance

Consider the following UML class diagram (noting that `StaffMember` is an abstract class and contains one abstract method called `pay`).

  
<img width="721" height="700" alt="image" src="https://github.com/user-attachments/assets/bd4d2fd8-5834-4e99-9df8-d5c3c50d848c" />


  

The classes in this diagram are going to help you to model a payroll system.

> [!NOTE] 
> To pay an `Employee`, return their pay rate (this is essentially their salary).
> To pay an `Executive`, return their pay rate + their bonus.
> To pay an `Hourly` worker, return their pay rate * hours worked.
> To pay a `Volunteer`, return `0.0` (they don’t get paid).

<br>

> [!NOTE] 
> The `awardBonus` method in the `Executive` class should increase the bonus for a given executive by the specified amount.
> The `resetBonus` method in the `Executive` class should reset the bonus for a given executive to `0.0`.
> The `addHours` method in the `Hourly` class should increase the hours worked for a given hourly worker by the specified amount.
> The `subtractHours` method in the `Hourly` class should decrease the hours worked for a given hourly worker by the specified amount.

<br>

> [!NOTE] 
> The `equals()` method in the `Employee` class should determine if two `Employee` objects have the same `payRate`.
> The `equals()` method in the `Executive` class should determine if two `Executive` objects have the same `bonus`.
> The `equals()` method in the `Hourly` class should determine if two `Hourly` objects have the same `hoursWorked`.

<br>

## To Do

  
**1.** Create an IntelliJ project and add these classes to it. Add getter/setter methods for each of the properties in each class along with suitable constructor methods for each class.

<br>

  
**2.** Create another class called `Firm`. This class should have a `main` method.

<br>


  
**3.** In the `Firm` class, create an `ArrayList` to hold `StaffMember` objects and complete the following tasks.

<br>


**4.** Create an `Executive` object called `ex1` with the following details and then add it to your `ArrayList`.

| Property | Value |
|---|---|
| Name | Dave |
| Address | Washington St |
| Phone | 345665 |
| Social security number | 4513-45-89 |
| Pay rate | 15000.45 |
| Bonus | 0.0 |

  <br>
  
**5.** Create an `Employee` object called `emp1` with the following details and then add it to your `ArrayList`.

  
| Property | Value |
|---|---|
| Name | Dom |
| Address | William St |
| Phone | 987654 |
| Social security number | 94-65-41 |
| Pay rate | 1200.15 |

<br>

**6.**  Create an `Hourly` object called `hrl1` with the following details and then add it to your `ArrayList`.

| Property | Value |
|---|---|
| Name | Liam |
| Address | Shop St |
| Phone | 986532 |
| Social security number | 984-474-325 |
| Hourly rate | 12.45 |
| Hours worked | 5 |

<br>

**7.**  Create a `Volunteer` object called `vol1` with the following details and then add it to your `ArrayList`.

| Property | Value |
|---|---|
| Name | Grace |
| Address | O’Connell St |
| Phone | 557282 |

<br>

**8.**  Award `ex1` a bonus of `9000.00`.

<br>

**9.** Increase the hours worked for `hrl1` by `40`.

<br>

**10.** Set the pay rate for `emp1` to `1000.00`.

<br>


**11.**  Create an `Executive` object called `ex2` with the following details and then add it to your `ArrayList`.

| Property | Value |
|---|---|
| Name | Tom |
| Address | Moylish Park |
| Phone | 784211 |
| Social security number | 4211-99-0 |
| Pay rate | 1799.45 |
| Bonus | 500.00 |

<br>


**12.** Award `ex2` a bonus of `700.00`.

<br>


**13.** Create an `Employee` object called `emp2` with the following details and then add it to your `ArrayList`.

| Property | Value |
|---|---|
| Name | Aoife |
| Address | Friars Sq |
| Phone | 716234 |
| Social security number | 99-61-42 |
| Pay rate | 2300.00 |

<br>



**14.** Write a method called `pay` and add it to your `Firm` class. This method will accept your `ArrayList` of objects as an argument and should not have a return value. Iterate over the `ArrayList` 
and “pay” each of the StaffMembers. As you pay each staff member, print to the screen:
- Their personal details.
- The sum of money they have received in payment.

_The information should be formatted appropriately._

In the case of a `Volunteer` (who does not receive any money), just print:

```text
Thanks!
```
The output should look something like the following:


<img width="490" height="724" alt="image" src="https://github.com/user-attachments/assets/d1561a44-61a0-4984-a00b-e628fa22ee9b" />



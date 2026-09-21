# Lab Exercise 2 — Arrays 👇

⏰ _The duration of this exam is 2hrs_ 

### Task One (15 Marks)

Create and initialise a two-dimensional int array with 10 rows and 10 columns. Each element in
the array is to be initialised to a random value in the range 1 – 100 (inclusive). You must create a
method to achieve this task. The signature of the method is to be as follows:

```java
private static int[][] initArray(int row, int col) { … }
```

Where row is the number of rows in the array and col is the number of columns in the array.
Once the method has completed, it is to return the newly created and initialised array.


<br>

### Task Two (5 Marks)
Print the array neatly to the screen (10 rows X 10 cols). You must create a method to achieve
this task. The signature of the method is to be as follows:

```java
public static void print(int[][] array) { … }
```

Where array is the array to be printed. For example:


<img width="718" height="450" alt="image" src="https://github.com/user-attachments/assets/a4e5b271-ddb5-4826-a69c-c4bc1cd48a2e" />


### Task Three (30 Marks)

Determine if any two adjacent values in a given row in the array sum to a specified value. Print
the indexes of these adjacent values to the console.

You must create a method to achieve this task. The signature of the method is to be as follows:
```java
private static void findAdjSums(int[][] array, int x) {..}
```

Where array is the array to search for adjacent numbers and where X is the target sum
value to find adjacent pairs.

For example, if the specified value (x) is 12 the output would be as follows:

<img width="715" height="582" alt="image" src="https://github.com/user-attachments/assets/338007c9-85dc-4d13-9179-96c9ace5f8ca" />

If no adjacent pairs can be found you should print a suitable message to the console.


<br>

### Task 4 (50 Marks)
Print the array in spiral form. You must write a method for this task, but you can decide on the
signature of the method yourself. The original array printed in spiral form would be as follows:

<img width="1146" height="243" alt="image" src="https://github.com/user-attachments/assets/541aa8b6-d35a-4faa-8718-ec7293bd1be9" />


_Printing a 2D array in spiral form means printing the elements around the outside first, then moving inward in a clockwise spiral._

<img width="457" height="426" alt="image" src="https://github.com/user-attachments/assets/54f79a4c-84df-4339-b1a8-7f38ec295d65" />

<br><br>


> [!IMPORTANT]
> This exercise is a previous Assignment One and is intended to give you a good indication of the style, format and standard of the class test you can expect on October 5th.
> 
> [W3schools](https://www.w3schools.com) <br>
> [Geeks for Geeks](https://www.geeksforgeeks.org) 
>
> You may also refer to my notes on [Moodle](https://moodle.midwest.tus.ie/course/view.php?id=22041) along with the source code for this module on [GitHub](https://github.com/lit-alan/SD3-Applications-Programming)
>
> There is little benefit in using Gen AI or other external sources when attempting this exercise, as the **solution will be provided afterwards**. To get an accurate indication of where you stand ahead of Assignment One, you should attempt this exercise under **exam conditions**, without external assistance.


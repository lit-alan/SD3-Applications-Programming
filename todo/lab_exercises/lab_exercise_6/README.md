## Lab Exercise 6️⃣ - Predicates, Comparators and `compareTo()`

The `Product` record and the `products` list used in these exercises are from the previous [lab exercise](https://github.com/lit-alan/SD3-Applications-Programming/tree/master/todo/lab_exercises/lab_exercise_5). Reuse that record and list;

## Exercise 1 - Predicate: Products on Sale

Create a `Predicate<Product>` called `onSalePredicate` that returns `true` if a product is currently on sale.

Use the predicate to display the names of all products that satisfy the condition.

**Expected output:**


  

<img width="361" height="166" alt="image" src="https://github.com/user-attachments/assets/daf22803-8609-4ffd-bb98-9133f6304697" />


   

<br>

   
> [!NOTE]
> `Predicate<T>` is a functional interface from the Java standard library (`java.util.function`) that represents a test which accepts an object of type `T` and returns a `boolean`.
>
> **Key concepts:**
> - `Predicate<T>` defines a condition that can be tested against an object.
> - `test()` is the method that evaluates the predicate and returns `true` or `false`.
> - Lambda expressions can be used to implement a predicate.
> - `Stream.filter()` accepts a predicate and retains only elements for which the predicate returns `true`.

## Exercise 2 - Comparator: Sort by Price

Create a `Comparator<Product>` called `priceComparator` that sorts products by price in ascending order.

Use the comparator to display the names and prices of all products, from cheapest to most expensive.

**Expected output:**


  

<img width="360" height="379" alt="image" src="https://github.com/user-attachments/assets/81d1d5ec-5a20-41c4-8699-818ecec1ea7b" />

  


## Exercise 3 - Comparator: Multiple Sorting Criteria

Create a `Comparator<Product>` that sorts products by:

1. Rating in descending order.
2. If two products have the same rating, name in ascending alphabetical order.

Display the product names and ratings.

**Expected output:**

  

  
<img width="627" height="367" alt="image" src="https://github.com/user-attachments/assets/a8456d7d-8927-4f09-919c-db1b63ff3745" />



  

## Exercise 4 — `compareTo()`: Comparing Products

Modify the `Product` record from Lab Exercise 5 so that it implements `Comparable<Product>`.

Override `compareTo()` so that products are compared by their names in alphabetical order.

Then use `products.stream().sorted()` to display all product names alphabetically.


**Expected output:**


   

<img width="454" height="373" alt="image" src="https://github.com/user-attachments/assets/b17d7f4e-ebe8-447e-998d-b40e65f6fc0a" />


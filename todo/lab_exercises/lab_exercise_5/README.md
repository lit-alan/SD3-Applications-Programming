## Lab Exercise 5️⃣

This exercise develops your understanding of functional programming concepts in Java, using custom functional interfaces, lambda expressions, and list processing.  


You will work with a 'Product' record and a set of small functional interfaces to perform  operations such as calculating averages, comparing products, filtering lists, and adjusting prices.

The main goal is to demonstrate how lambda expressions can replace traditional anonymous classes (we haven’t looked at these yet so don’t fret about them) or loops by making your code more expressive and reusable.

The starter code comes with five functional interfaces and a 'Product' record definition In the 'Main', a list or Products is populated with 10 product objects.

## Task 1 – Average Price of Two Products

Write a lambda expression using the `ProductOperation` interface that takes two products (p1 and p2) and returns the average of their prices. This lambda is then called with the first two products in the list (prod1 and prod2), and the result is formatted using the Irish currency locale. The output should look like the following:

```text
Average price of p1 and p2 :  €1,025.00
```

## Task 2 – Check if Two Products Are in the Same Category

Define a `ProductOperation` lambda that checks if two products (use prod1 and prod2 again) belong to the same category. 

The lambda should return 1 if they do, and 0 otherwise.

```text
Same category? true
```

## Task 3 – Compare Two Products

Create a `ProductAction` lambda that prints a formatted comparison of two products (again use prod1 and prod2), displaying their names and the price difference.

```text
Laptop vs Smartphone
Price difference: €350.00
```

## Task 4 – Average Price Across the Product List

Implement a `ProductListOperation` lambda that calculates the average price of all products in the list. If the list is empty, the lambda should return 0.

```text
Average price of all products: €328.00
```

## Task 5 – Price Difference Between Consecutive Products

Write a `ProductListOperation` lambda that compares each product to the next one in the list and prints the price difference. The output should look something like the following:

```text
Laptop vs Smartphone
Price difference: €350.00

Smartphone vs Running Shoes
Price difference: €755.00

Running Shoes vs Coffee Maker
Price difference: €85.00

Coffee Maker vs Wireless Headphones
Price difference: €40.00

Wireless Headphones vs Desk Lamp
Price difference: €160.00

Desk Lamp vs Leather Jacket
Price difference: €90.00

Leather Jacket vs Gaming Mouse
Price difference: €75.00

Gaming Mouse vs Office Chair
Price difference: €245.00

Office Chair vs Blender
Price difference: €190.00
```

## Task 6 – Total Stock Value

Create a ProductListOperation lambda that calculates the total stock value for all products by multiplying each product’s price by its stock quantity.

```text
Total stock value: €44,940.00
```

## Task 7 – Price Adjustment Using a Lambda

Write a lambda expression for the `PriceAdjuster` interface that increases a product’s (use prod1) price by a given percentage and returns a new `Product` instance reflecting this change. Notice the increase in the price below.

```text
Product[id=P1001, name=Laptop, category=Electronics, price=1320.0, costPrice=900.0, stock=8, rating=4.5, onSale=false, supplier=TechWorld]
```

-----------

# Filter Operations

From here onward, the focus shifts to filtering lists of products using predicates implemented as lambdas.

## The filterProducts Methods

You must write two overloaded `filterProducts` methods. They form the foundation ofvTasks 8–11 and must be clearly understood before implementing the filters.

## Method 1 — Single Filter

```java
public static List<Product> filterProducts(List<Product> products, ProductFilter filter)
```

This version applies a single filtering condition to a list of products. It iterates through the list, tests each product against the provided `ProductFilter`, and collects those that return true.


## Method 2 — Multiple Filters with AND/OR Logic

```java
public static List<Product> filterProducts(
    List<Product> products,
    boolean useAndLogic,
    ProductFilter... filters)
```

This version supports combining multiple filters (lambdas) using either AND logic or OR logic, depending on the `useAndLogic` flag.

If `useAndLogic` is `true`, a product must satisfy all filters to be included.  
If `useAndLogic` is `false`, a product is included if it satisfies any filter.

In other words, `useAndLogic` is a control flag that tells the `filterProducts` method how to combine multiple filters. When `useAndLogic == true` we’re saying “keep a product only if it meets every condition.” When `useAndLogic == false` we’re saying: “keep a product if it meets any one of the conditions.”

*By “keep a product”, I’m referring to the decision the filtering method makes about whether a product should be included in the final filtered list that gets returned.*


## Task 8 – Filtering: On Sale, Highly Rated, and Affordable

Define a `ProductFilter` lambda that returns true if a product is on sale, has a rating of 4.5 or above, and is priced under €500. Only one product matches this criteria.

```text
=== Products On Sale, Highly Rated, and Under €500 ===
Product[id=P1007, name=Leather Jacket, category=Fashion, price=150.0, costPrice=70.0, stock=12, rating=4.6, onSale=true, supplier=CoolWear]
```

## Task 9 – Filtering: Low Stock or TechWorld Supplier

Define another `ProductFilter` lambda that identifies products that either belong to the Electronics category with stock below 10 or are supplied by TechWorld. Two products  
match this criteria.

```text
=== Electronics with Low Stock OR from TechWorld ===
Product[id=P1001, name=Laptop, category=Electronics, price=1200.0, costPrice=900.0, stock=8, rating=4.5, onSale=false, supplier=TechWorld]
Product[id=P1008, name=Gaming Mouse, category=Electronics, price=75.0, costPrice=40.0, stock=40, rating=4.4, onSale=false, supplier=TechWorld]
```

## Task 10 – Combined Filter Using AND Logic

Select all products that are simultaneously Expensive (price > €500), On Sale, and Highly Rated (rating ≥ 4.5). Develop three `ProductFilter` lambdas and combine them with  
`useAndLogic = true`. One product match this criteria.

```text
=== Products that are Expensive AND On Sale AND Highly Rated ===
Product[id=P1002, name=Smartphone, category=Electronics, price=850.0, costPrice=600.0, stock=15, rating=4.7, onSale=true, supplier=SmartCo]
```

## Task 11 – Combined Filter Using OR Logic

Select all products that meet any of the same three conditions: price > €500, on sale, or rating ≥ 4.5. Combine them with `useAndLogic = false`. Six products match this criteria.

```text
=== Products that are Expensive OR On Sale OR Highly Rated ===
Product[id=P1001, name=Laptop, category=Electronics, price=1200.0, costPrice=900.0, stock=8, rating=4.5, onSale=false, supplier=TechWorld]
Product[id=P1002, name=Smartphone, category=Electronics, price=850.0, costPrice=600.0, stock=15, rating=4.7, onSale=true, supplier=SmartCo]
Product[id=P1004, name=Coffee Maker, category=Home, price=180.0, costPrice=120.0, stock=5, rating=4.0, onSale=true, supplier=HomeEase]
Product[id=P1005, name=Wireless Headphones, category=Electronics, price=220.0, costPrice=140.0, stock=25, rating=4.8, onSale=false, supplier=SoundMax]
Product[id=P1007, name=Leather Jacket, category=Fashion, price=150.0, costPrice=70.0, stock=12, rating=4.6, onSale=true, supplier=CoolWear]
Product[id=P1010, name=Blender, category=Home, price=130.0, costPrice=80.0, stock=18, rating=4.2, onSale=true, supplier=KitchenPro]
```

After completing all tasks, you will 😄

- Understand and be able to implement custom functional interfaces in Java.
- Know how to use lambda expressions to define operations and predicates concisely.
- Be able to apply filtering logic dynamically using overloaded methods.
- Understand AND/OR boolean logic in functional composition.
- Appreciate how immutable data records can be manipulated functionally.

import interfaces.*;
import model.Product;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {



        List<Product> products = List.of(
                new Product("P1001", "Laptop", "Electronics", 1200.0, 900.0, 8, 4.5, false, "TechWorld"),
                new Product("P1002", "Smartphone", "Electronics", 850.0, 600.0, 15, 4.7, true, "SmartCo"),
                new Product("P1003", "Running Shoes", "Fashion", 95.0, 50.0, 30, 4.2, false, "UrbanStep"),
                new Product("P1004", "Coffee Maker", "Home", 180.0, 120.0, 5, 4.0, true, "HomeEase"),
                new Product("P1005", "Wireless Headphones", "Electronics", 220.0, 140.0, 25, 4.8, false, "SoundMax"),
                new Product("P1006", "Desk Lamp", "Home", 60.0, 25.0, 50, 4.1, false, "BrightLite"),
                new Product("P1007", "Leather Jacket", "Fashion", 150.0, 70.0, 12, 4.6, true, "CoolWear"),
                new Product("P1008", "Gaming Mouse", "Electronics", 75.0, 40.0, 40, 4.4, false, "TechWorld"),
                new Product("P1009", "Office Chair", "Furniture", 320.0, 180.0, 10, 4.3, false, "ErgoSeat"),
                new Product("P1010", "Blender", "Home", 130.0, 80.0, 18, 4.2, true, "KitchenPro")
        );

        //products.forEach(System.out::println);

        Product prod1 = products.get(0);
        Product prod2 = products.get(1);

        Locale locale = new Locale("en", "IE");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);

        //////////////////////////////////////////////////////////////////
        //TASK 1 - Write a lambda to find the average price of the first two products in the list
        //////////////////////////////////////////////////////////////////
        ProductOperation averagePrice = (Product p1, Product p2) -> (p1.price() + p2.price()) / 2;

        /*
         * Alternative version using Java's streaming api
         */
//        double avg = products.stream()
//                .mapToDouble(Product::price)
//                .average()
//                .orElse(0.0);
        System.out.println("Task 1");
        System.out.println("Average price of p1 and p2 :  " + cf.format(averagePrice.operation(prod1,prod2)));






       //////////////////////////////////////////////////////////////////
        //TASK 2 -Write a lambda to check if the first two products are in the same category
        //////////////////////////////////////////////////////////////////
        ProductOperation sameCategory = (p1, p2) ->
                p1.category().equals(p2.category()) ? 1 : 0;

        System.out.println("\nTask 2");
        System.out.println("Same category? " + (sameCategory.operation(prod1, prod2) == 1));

        //////////////////////////////////////////////////////////////////
        //TASK 3
        //////////////////////////////////////////////////////////////////
        System.out.println("\nTask 3");
        ProductAction printComparison = (p1, p2) -> {
            System.out.println(p1.name() + " vs " + p2.name());
            System.out.println("Price difference: " + cf.format(Math.abs(p1.price() - p2.price())));
        };
        printComparison.apply(prod1, prod2);


        //////////////////////////////////////////////////////////////////
        //TASK 4
        //////////////////////////////////////////////////////////////////
        ProductListOperation averageListPrice = list -> {
            if (list.isEmpty()) return 0; // avoid division by zero
            double total = 0;
            for (Product p : list) {
                total += p.price();
            }
            return total / list.size();
        };

        /*
         * Alternative version using Java's streaming api
         */
//        ProductListOperation averageListPrice =
//                list -> list.stream().mapToDouble(Product::price).average().orElse(0);


        // Use the lambda
        double avg = averageListPrice.operation(products);
        System.out.println("\nTask 4");
        System.out.println("Average price of all products: " + cf.format(avg));

        //////////////////////////////////////////////////////////////////
        //TASK 5
        //////////////////////////////////////////////////////////////////
        ProductListOperation printListComparison = list -> {
            for (int i = 0; i < list.size() - 1; i++) {
                Product p1 = list.get(i);
                Product p2 = list.get(i + 1);
                System.out.println(p1.name() + " vs " + p2.name());
                System.out.println("Price difference: " +
                        cf.format(Math.abs(p1.price() - p2.price())));
                System.out.println();
            }
            return 0; // Return type required by interface
        };

        /*
         * Alternative version using Java's streaming api
         */
//        ProductListOperation printListComparison = list -> {
//            java.util.stream.IntStream.range(0, list.size() - 1)
//                    .forEach(i -> {
//                        var p1 = list.get(i);
//                        var p2 = list.get(i + 1);
//                        System.out.printf("%s vs %s%nPrice difference: %s%n%n",
//                                p1.name(), p2.name(),
//                                cf.format(Math.abs(p1.price() - p2.price())));
//                    });
//            return 0;
//        };

        //Apply the lambda to the full list
        System.out.println("\nTask 5");
        printListComparison.operation(products);

        //////////////////////////////////////////////////////////////////
        //TASK 6
        //////////////////////////////////////////////////////////////////
        ProductListOperation totalStockValue = list -> {
            double total = 0;
            for (Product p : list)
                total += p.price() * p.stock();
            return total;
        };

        /*
         * Alternative version using Java's streaming api
         */

//        ProductListOperation totalStockValue = list -> {
//            double t = 0; for (var p : list) t += p.price() * p.stock(); return t;
//        };


        System.out.println("\nTask 6");
        System.out.println("Total stock value: " + cf.format(totalStockValue.operation(products)));

        //TASK 7
        PriceAdjuster increase = (p, percent) ->
                new Product(p.id(), p.name(), p.category(), p.price() * (1 + percent), p.costPrice(),
                        p.stock(), p.rating(), p.onSale(), p.supplier());

        Product adjusted = increase.adjust(prod1, 0.10); // 10% increase
        System.out.println("\nTask 7");
        System.out.println(adjusted);







        //Task 8 - Filtering Lambda 1 — product is on sale, rating >= 4.5, and price < 500
        ProductFilter saleAndHighlyRated = p ->
                p.onSale() && p.rating() >= 4.5 && p.price() < 500;

        //Task 9 - Filtering Lambda 2 — products is in electronics category with stock < 10 or supplier "TechWorld"
        ProductFilter lowStockOrTechWorld = p ->
                (p.category().equals("Electronics") && p.stock() < 10)
                        || p.supplier().equals("TechWorld");

        List<Product> filtered1 = filterProducts(products, saleAndHighlyRated);
        List<Product> filtered2 = filterProducts(products, lowStockOrTechWorld);

        //print results
        System.out.println("\nTask 8\n=== Products On Sale, Highly Rated, and Under $500 ===");
        filtered1.forEach(System.out::println);

        System.out.println("\nTask 9\n Electronics with Low Stock OR from TechWorld ===");
        filtered2.forEach(System.out::println);


        //Lambda - expensive products
        ProductFilter expensive = p -> p.price() > 500;

        //Lambda  - on sale products
        ProductFilter onSale = p -> p.onSale();
        //ProductFilter onSale = Product::onSale;

        //Lambda - highly rated products
        ProductFilter highlyRated = p -> p.rating() >= 4.5;

        //Combine filters with AND
        List<Product> filteredAnd = filterProducts(products, true, expensive, onSale, highlyRated);

        //Combine filters with OR
        List<Product> filteredOr = filterProducts(products, false, expensive, onSale, highlyRated);

        // Print results
        System.out.println("\nTASK 10  - Products that are Expensive AND On Sale AND Highly Rated");
        filteredAnd.forEach(System.out::println);

        System.out.println("\nTASK 11 - Products that are Expensive OR On Sale OR Highly Rated");
        filteredOr.forEach(System.out::println);
    }

    //Define a reusable filtering method
    public static List<Product> filterProducts(List<Product> products, ProductFilter filter) {
        List<Product> filtered = new ArrayList();
        for (Product p : products) {
            if (filter.test(p)) {
                filtered.add(p);
            }
        }
        return filtered;
    }

    //Filter method — combine filters with AND / OR logic
    public static List<Product> filterProducts(
            List<Product> products,
            boolean useAndLogic,
            ProductFilter... filters) {

        List<Product> result = new ArrayList<>();

        for (Product p : products) {
            //start with true for AND, false for OR
            boolean matches = useAndLogic;

            for (ProductFilter filter : filters) {
                if (useAndLogic) {
                    matches = matches && filter.test(p);
                    //short-circuit AND
                    if (!matches) break;
                } else {
                    matches = matches || filter.test(p);
                    //short-circuit OR
                    if (matches) break;
                }
            }

            if (matches) result.add(p);
        }

        return result;
    }


}

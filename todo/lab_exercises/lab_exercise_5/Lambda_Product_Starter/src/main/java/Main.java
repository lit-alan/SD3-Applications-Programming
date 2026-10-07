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

        //print all products
        //products.forEach(System.out::println);

        Product prod1 = products.get(0);
        Product prod2 = products.get(1);

    }

}

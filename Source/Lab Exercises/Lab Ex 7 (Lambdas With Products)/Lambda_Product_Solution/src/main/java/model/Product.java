package model;

public record Product(
        String id,             //unique product code, e.g. "P1001"
        String name,           //descriptive product name
        String category,       //e.g. "Electronics", "Home", "Fashion"
        double price,          //current retail price
        double costPrice,      //cost to the store (for profit calculations)
        int stock,             //how many units available
        double rating,         //average customer rating (0–5)
        boolean onSale,        //whether it’s currently discounted
        String supplier        //name of the supplier or brand
) {}

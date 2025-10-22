package interfaces;

import model.Product;

@FunctionalInterface
public interface PriceAdjuster {
    Product adjust(Product p, double percent);
}
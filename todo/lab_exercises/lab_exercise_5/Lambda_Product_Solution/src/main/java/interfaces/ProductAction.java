package interfaces;

import model.Product;

@FunctionalInterface
public interface ProductAction {
    void apply(Product p1, Product p2);
}
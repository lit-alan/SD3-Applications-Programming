package interfaces;

import model.Product;

@FunctionalInterface
public interface ProductFilter {
    boolean test(Product p);
}

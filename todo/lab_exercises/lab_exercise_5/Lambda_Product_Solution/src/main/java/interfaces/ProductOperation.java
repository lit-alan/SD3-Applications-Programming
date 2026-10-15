package interfaces;

import model.Product;

import java.util.List;

@FunctionalInterface
public interface ProductOperation {
    double operation(Product p1, Product p2);

}

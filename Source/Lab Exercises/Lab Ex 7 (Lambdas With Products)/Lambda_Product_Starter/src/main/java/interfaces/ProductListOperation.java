package interfaces;

import model.Product;

import java.util.List;

/*
 *   Works with lists of products.
 *   This interface can handle any number of products.
 */
@FunctionalInterface
public interface ProductListOperation {
    double operation(List<Product> products);
}

package kata.supermarket.domain;

import java.util.Objects;

public class Product {

    private String productName;

    private Product(String produtName) {
        this.productName = produtName;
    }


    public static Product aProduct(String productName) {
        return new Product(productName);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }
}

package kata.supermarket.domain;

import java.util.Objects;

import static kata.supermarket.domain.Product.aProduct;

/**
 * Created by Vitalii on 09.08.2018.
 */
public class Item {
    private Product product;
    private Price nominalPrice;
    private int quantity;

    private Item(Product product, Price nominalPrice, int quantity) {
        this.product = product;
        this.nominalPrice = nominalPrice;
        this.quantity = quantity;
    }

    public static Item anItem(Product product, Price price, int quantity) {
        return new Item(product, price, quantity);
    }

    public static Item anItem(String productName, Price price, int quantity) {
        return new Item(aProduct(productName), price, quantity);
    }

    public Money getTotalCost(){
        return nominalPrice.calculateTotalCost(quantity);
    }
    public Price getNominalPrice() {
        return nominalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return quantity == item.quantity &&
                Objects.equals(product, item.product) &&
                Objects.equals(nominalPrice, item.nominalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, nominalPrice, quantity);
    }
}

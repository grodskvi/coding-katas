package kata.supermarket.domain;


import kata.supermarket.registry.ProductPriceRegistry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static kata.supermarket.domain.Bill.aBill;
import static kata.supermarket.domain.Item.anItem;

public class Cart {
    private Collection<Item> purchasedItems;
    private ProductPriceRegistry productPriceRegistry;

    public Cart(ProductPriceRegistry productPriceRegistry) {
        this.purchasedItems = new ArrayList<>();
        this.productPriceRegistry = productPriceRegistry;
    }

    public void addItem(Product product, int quantity) {
        Price productPrice = productPriceRegistry.getProductPrice(product);
        this.purchasedItems.add(anItem(product, productPrice, quantity));
    }

    public Collection<Item> getPurchasedItems() {
        return Collections.unmodifiableCollection(purchasedItems);
    }

    public Bill payout() {
        Money totalAmount = new Money("0");
        for (Item item : getPurchasedItems()) {
            totalAmount = totalAmount.add(item.getTotalCost());
        }
        return aBill(totalAmount);
    }
}

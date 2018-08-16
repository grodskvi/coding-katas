package kata.supermarket.registry;

import kata.supermarket.domain.Price;
import kata.supermarket.domain.Product;

public interface ProductPriceRegistry {
    Price getProductPrice(Product product);
}

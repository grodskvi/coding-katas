package kata.supermarket.domain;

import java.math.BigDecimal;

public class Price {

    private BigDecimal priceValue;

    public Price(BigDecimal priceValue) {
        this.priceValue = priceValue;
    }

    public Money calculateTotalCost(int quantity) {
        return new Money(priceValue.multiply(new BigDecimal(quantity)));
    }

    public static Price aPrice(BigDecimal price) {
        return new Price(price);
    }
}

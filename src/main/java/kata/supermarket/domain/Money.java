package kata.supermarket.domain;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by Vitalii on 09.08.2018.
 */
public class Money {
    private BigDecimal amount;

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money(String amount) {
        this.amount = new BigDecimal(amount);
    }


    public int getValue() {
        return amount.intValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return Objects.equals(amount, money.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    public Money add(Money anotherMoney) {
        return new Money(anotherMoney.amount.add(amount));
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                '}';
    }
}

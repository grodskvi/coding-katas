package kata.supermarket.domain;

import java.util.Objects;

/**
 * Created by Vitalii on 09.08.2018.
 */
public class Bill {

    private Money money;

    private Bill(Money money) {
        this.money = money;
    }

    public Money getCost() {
        return money;
    }

    public static Bill aBill(Money money) {
        return new Bill(money);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return Objects.equals(money, bill.money);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}

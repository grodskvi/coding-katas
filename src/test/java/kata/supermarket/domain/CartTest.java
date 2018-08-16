package kata.supermarket.domain;

import kata.supermarket.registry.ProductPriceRegistry;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static kata.supermarket.domain.Item.anItem;
import static kata.supermarket.domain.Price.aPrice;
import static kata.supermarket.domain.Product.aProduct;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CartTest {

    @Mock
    private ProductPriceRegistry productPriceRegistry;

    @InjectMocks
    private Cart cart;


    private static final Price CARROT_PRICE = aPrice(new BigDecimal("2"));
    private static final Price RABBIT_PRICE = aPrice(new BigDecimal("5"));

    @Before
    public void setUp() {
        when(productPriceRegistry.getProductPrice(aProduct("Carrot"))).thenReturn(CARROT_PRICE);
        when(productPriceRegistry.getProductPrice(aProduct("Rabbit"))).thenReturn(RABBIT_PRICE);
    }
    @Test
    public void emptyBillHasNoItems() throws Exception {
        assertThat(cart.getPurchasedItems()).isEmpty();
    }

    @Test
    public void containsPurchasedProducts() throws Exception {
        cart.addItem(aProduct("Carrot"), 1);

        assertThat(cart.getPurchasedItems()).containsExactly(anItem("Carrot", CARROT_PRICE, 1));
    }

    @Test
    public void containsAllPurchasedProducts() throws Exception {
        cart.addItem(aProduct("Carrot"), 1);
        cart.addItem(aProduct("Rabbit"), 10);

        assertThat(cart.getPurchasedItems()).containsExactly(anItem("Carrot", CARROT_PRICE, 1),anItem("Rabbit", RABBIT_PRICE, 10));
    }

    @Test
    public void payoutsCart() throws Exception {
        cart.addItem(aProduct("Carrot"), 1); // 2
        cart.addItem(aProduct("Rabbit"), 10);// 5

        Bill bill = cart.payout();
        assertThat(bill.getCost()).isEqualTo(new Money("52"));
    }
}

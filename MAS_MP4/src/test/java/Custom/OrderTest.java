package Custom;

import org.junit.Before;
import org.junit.Test;

import java.util.IllformedLocaleException;

import static org.junit.Assert.*;

public class OrderTest {
    @Test
    public void test() {
        Order order = new Order("13434", Shipping.PAID, 150);
        assertThrows(IllegalArgumentException.class,
                () -> order.setShipping(Shipping.FREE));
    }
}
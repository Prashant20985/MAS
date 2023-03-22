package Unique;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderTest {

    private Order order;
    private Product product1;
    private Product product2;

    @Before
    public void setUp(){
        order = new Order(1);
        product1 = new Product(1, "Product 1", 10.0);
        product2 = new Product(2, "Product 2", 20.0);
    }

    @Test
    public void testAddProduct() throws Exception {
        order.addProduct(product1);
        assertEquals(1, order.getProducts().size());
        assertTrue(order.getProducts().contains(product1));

        order.addProduct(product2);
        assertEquals(2, order.getProducts().size());
        assertTrue(order.getProducts().contains(product1));
        assertTrue(order.getProducts().contains(product2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddDuplicateProduct() throws Exception {
        order.addProduct(product1);
        order.addProduct(product1); // should throw an exception
    }

    @Test
    public void testRemoveProduct() throws Exception {
        order.addProduct(product1);
        order.addProduct(product2);
        assertEquals(2, order.getProducts().size());

        order.removeProduct(product1);
        assertEquals(1, order.getProducts().size());
        assertFalse(order.getProducts().contains(product1));
        assertTrue(order.getProducts().contains(product2));

        order.removeProduct(product2);
        assertEquals(0, order.getProducts().size());
        assertFalse(order.getProducts().contains(product1));
        assertFalse(order.getProducts().contains(product2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveNonexistentProduct() throws Exception {
        order.removeProduct(product1); // should throw an exception
    }
}

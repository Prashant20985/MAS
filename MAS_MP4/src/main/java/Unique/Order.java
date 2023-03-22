package Unique;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Order {
    private int id;
    private final Set<Product> products = new HashSet<>();

    public Order(int id) {
        setId(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Product> getProducts() {
        return Collections.unmodifiableSet(products);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void addProduct(Product product){
        if(product == null){
            throw new IllegalArgumentException("Product must not be null");
        }
        if(products.contains(product)){
            throw new IllegalArgumentException("Product is already in this order");
        }
        products.add(product);
    }

    public void removeProduct(Product product) {
        if(product == null){
            throw new IllegalArgumentException("Product must not be null");
        }
        if (!products.contains(product)) {
            throw new IllegalArgumentException("Product is not in this order");
        }
        products.remove(product);
    }
}

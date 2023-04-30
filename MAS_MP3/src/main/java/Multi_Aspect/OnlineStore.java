package Multi_Aspect;

import java.util.ArrayList;

public class OnlineStore {
    private ArrayList<Product> products;
    private Shipping shippingMethod;

    public OnlineStore(Shipping shippingMethod) {
        products = new ArrayList<>();
        this.shippingMethod = shippingMethod;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public Shipping getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(Shipping shippingMethod) {
        if (shippingMethod == null)
            throw new IllegalArgumentException("Shipping method must not be null");
        this.shippingMethod = shippingMethod;
    }

    public void addProduct(Product product) {
        if(product == null)
            throw new IllegalArgumentException("Product must not be null");
        if(products.contains(product))
            return;
        products.add(product);
    }

    public void removeProduct(Product product){
        if(product == null)
            throw new IllegalArgumentException("Product must not be null");
        if(!products.contains(product))
            return;
        products.remove(product);
    }

    public double calculateTotalPrice(double discountRate) {
        double totalCost = products.stream().mapToDouble(x -> x.calculateDiscount(discountRate)).sum();
        double shippingCost = shippingMethod.calculateShippingCost();
        totalCost += shippingCost;
        return totalCost;
    }
}

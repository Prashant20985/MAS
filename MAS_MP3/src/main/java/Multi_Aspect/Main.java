package Multi_Aspect;

public class Main {
    public static void main(String[] args) {

        Product book1 = new Book(10.99,"The Great Gatsby",  "F. Scott Fitzgerald");
        Product book2 = new Book(12.99, "To Kill a Mockingbird", "Harper Lee");
        Product tshirt1 = new TShirt(19.99,"Men's Graphic Tee",  "L");
        Product tshirt2 = new TShirt(24.99,"Women's V-Neck Tee",  "M");

        // Create some shipping methods
        Shipping standardShipping = new StandardShipping(2.5);
        Shipping expressShipping = new ExpressShipping(2.5);

        // Create an online store with standard shipping and add products
        OnlineStore store = new OnlineStore(standardShipping);
        store.addProduct(book1);
        store.addProduct(tshirt1);

        // Calculate total cost with 10% discount
        double totalCost = store.calculateTotalPrice(0.1);
        System.out.println("Total cost with standard shipping and 10% discount: $" + totalCost);

        // Change shipping method to express shipping and add more products
        store.setShippingMethod(expressShipping);
        store.addProduct(book2);
        store.addProduct(tshirt2);

        // Calculate total cost with 20% discount
        totalCost = store.calculateTotalPrice(0.2);
        System.out.println("Total cost with express shipping and 20% discount: $" + totalCost);
    }
}

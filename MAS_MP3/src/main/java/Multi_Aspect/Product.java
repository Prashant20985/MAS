package Multi_Aspect;

public abstract class Product {
    protected double price;
    protected String name;

    public Product(double price, String name) {
        this.price = price;
        setName(name);
    }

    public abstract double calculateDiscount(double discountRate);

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or blank");
        this.name = name;
    }
}

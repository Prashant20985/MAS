package Multi_Aspect;

public class TShirt extends Product {
    private String size;

    public TShirt(double price, String name, String size) {
        super(price, name);
        setSize(size);
    }

    public String getSize() {
        return size;
    }

    private void setSize(String size) {
        if (size == null || size.isBlank())
            throw new IllegalArgumentException("TShirt Size must not be blank or null");
        this.size = size;
    }

    @Override
    public double calculateDiscount(double discountRate) {
        double discountedPrice = price * (1 - discountRate);
        return discountedPrice;
    }
}

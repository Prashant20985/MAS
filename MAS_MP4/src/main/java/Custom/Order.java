package Custom;

public class Order {
    private String orderNumber;
    private Shipping shipping;
    private double totalPurchasePrice;

    public Order(String orderNumber, Shipping shipping, double totalPurchasePrice) {
        setOrderNumber(orderNumber);
        setTotalPurchasePrice(totalPurchasePrice);
        setShipping(shipping);
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        if (orderNumber == null || orderNumber.isBlank())
            throw new IllegalArgumentException("Order number must not be blank or null");
        this.orderNumber = orderNumber;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        if(shipping == null)
            throw new IllegalArgumentException("Purchase must not be null");
        if (!(shipping.getMinPurchasePrice() < totalPurchasePrice
                && shipping.getMaxPurchasePrice() >= totalPurchasePrice))
            throw new IllegalArgumentException("Order not applicable for given shipment");
        this.shipping = shipping;
    }

    public double getTotalPurchasePrice() {
        return totalPurchasePrice;
    }

    public void setTotalPurchasePrice(double totalPurchasePrice) {
        if (totalPurchasePrice < 0)
            throw new IllegalArgumentException("Cannot be less than 0");
        this.totalPurchasePrice = totalPurchasePrice;
    }
}

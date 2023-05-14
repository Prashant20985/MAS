package Custom;

public enum Shipping {
    FREE(200, 500),
    PAID(0, 200);

    private final double minPurchasePrice;
    private final double maxPurchasePrice;

    Shipping(double minPurchasePrice, double maxPurchasePrice) {
        this.minPurchasePrice = minPurchasePrice;
        this.maxPurchasePrice = maxPurchasePrice;
    }

    public double getMinPurchasePrice() {
        return minPurchasePrice;
    }

    public double getMaxPurchasePrice() {
        return maxPurchasePrice;
    }
}

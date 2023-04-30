package Multi_Aspect;

public class StandardShipping extends Shipping{
    public StandardShipping(double weight) {
        super(weight, 2.99);
    }

    @Override
    public double calculateShippingCost() {
        double shippingCostPerKg = shippingCost / 1000;
        double totalShippingCost = shippingCostPerKg * weight;
        return totalShippingCost;
    }
}

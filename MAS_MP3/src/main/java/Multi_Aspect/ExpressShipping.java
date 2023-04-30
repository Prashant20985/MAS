package Multi_Aspect;

public class ExpressShipping extends Shipping {
    public ExpressShipping(double weight) {
        super(weight, 4.99);
    }

    @Override
    public double calculateShippingCost() {
        double shippingCostPerKg = shippingCost / 1000;
        double totalShippingCost = shippingCostPerKg * weight;
        totalShippingCost *= 1.5; // Express shipping costs 50% more
        return totalShippingCost;
    }
}

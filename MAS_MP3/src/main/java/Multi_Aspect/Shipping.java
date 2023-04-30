package Multi_Aspect;

public abstract class Shipping {
    protected double weight;
    protected double shippingCost;

    public Shipping(double weight, double shippingCost) {
        this.weight = weight;
        this.shippingCost = shippingCost;
    }

    public abstract double calculateShippingCost();

    public double getWeight() {
        return weight;
    }

    private void setWeight(double weight) {
        this.weight = weight;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    private void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }
}

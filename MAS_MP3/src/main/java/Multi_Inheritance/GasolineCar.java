package Multi_Inheritance;

public class GasolineCar extends Car {
    private int fuelLevel;
    private final int FUEL_CAPACITY = 50;

    public GasolineCar(String model, int year, int fuelLevel) {
        super(model, year);
        setFuelLevel(fuelLevel);
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        if (fuelLevel < 0) throw new IllegalArgumentException("Fuel Level must not be less than 0");
        this.fuelLevel = fuelLevel;
    }

    public void refillFuel(int amount) {
        if (fuelLevel + amount > FUEL_CAPACITY) {
            fuelLevel = FUEL_CAPACITY;
        } else {
            fuelLevel += amount;
        }
        System.out.println("fuelLevel= " + fuelLevel);
    }

    public void driveGasoline(int distance) {
        if (fuelLevel - distance < 0) {
            System.out.println("Not enough fuel to drive " + distance + " km.");
        } else {
            fuelLevel -= distance;
            System.out.println("Driving " + distance + " km on gasoline power. Current fuel level: " + fuelLevel);
        }
    }

    @Override
    public String toString() {
        return "GasolineCar{" +
                super.toString() + " " +
                "fuelLevel=" + fuelLevel +
                '}';
    }
}

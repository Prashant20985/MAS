package Multi_Inheritance;

public class ElectricCar extends Car implements ElectricDrive {
    private int batteryLevel;
    private final int BATTERY_CAPACITY = 100;

    public ElectricCar(String model, int year, int batteryLevel) {
        super(model, year);
        setBatteryLevel(batteryLevel);
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(int batteryLevel) {
        if (batteryLevel < 0)
            throw new IllegalArgumentException("Battery Level cannot be less than 0");
        this.batteryLevel = batteryLevel;
    }

    @Override
    public void chargeBattery(int amount) {
        if (batteryLevel + amount > BATTERY_CAPACITY) {
            batteryLevel = BATTERY_CAPACITY;
        } else {
            batteryLevel += amount;
        }
        System.out.println("Charging the battery. Current battery level: " + batteryLevel);
    }

    @Override
    public void driveElectric(int distance) {
        if (batteryLevel - distance < 0) {
            System.out.println("Not enough charge to drive " + distance + " km.");
        } else {
            batteryLevel -= distance;
            System.out.println("Driving " + distance + " km on electric power. Current battery level: " + batteryLevel);
        }
    }

    @Override
    public String toString() {
        return "ElectricCar{" +
                super.toString() + " " +
                "batteryLevel= " + batteryLevel +
                '}';
    }
}

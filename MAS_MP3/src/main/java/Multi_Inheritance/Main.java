package Multi_Inheritance;

public class Main {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar("Car 1", 2022, 80);
        GasolineCar gasolineCar = new GasolineCar("Car 2", 2023, 35);
        HybridCar hybridCar = new HybridCar("Car 3", 2023, 25, 75);

        System.out.println("electricCar = " + electricCar);
        System.out.println("gasolineCar = " + gasolineCar);
        System.out.println("hybridCar = " + hybridCar);

        System.out.println();

        System.out.println(electricCar.getModel());
        electricCar.chargeBattery(20);
        electricCar.driveElectric(80);

        System.out.println();

        System.out.println(gasolineCar.getModel());
        gasolineCar.refillFuel(5);
        gasolineCar.driveGasoline(30);

        System.out.println();

        System.out.println(hybridCar.getModel());
        hybridCar.chargeBattery(10);
        hybridCar.driveElectric(20);
        hybridCar.refillFuel(10);
        hybridCar.driveGasoline(25);
    }
}

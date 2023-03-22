package Abstract_Polymorphic;

public abstract class Phone {
    protected String model;
    protected String operatingSystem;
    protected int batteryLevel;
    protected boolean isCharging;

    public Phone(String model, String operatingSystem) {
        this.model = model;
        this.operatingSystem = operatingSystem;
        this.batteryLevel = 100;
        this.isCharging = false;
    }

    public abstract void call(String phoneNumber);
    public abstract void sendMessage(String phoneNumber, String message);
    public abstract void browseWeb(String url);
    public abstract void takePhoto();

    public void charge() {
        if (!isCharging) {
            System.out.println("Charging phone...");
            isCharging = true;
            while (batteryLevel < 100) {
                batteryLevel += 10;
                System.out.println("Battery level: " + batteryLevel + "%");
            }
            System.out.println("Phone fully charged.");
            isCharging = false;
        } else {
            System.out.println("Phone is already charging.");
        }
    }

    public void checkBatteryLevel() {
        System.out.println("Battery level: " + batteryLevel + "%");
    }

    public void turnOn() {
        System.out.println("Turning on phone...");
        System.out.println("Welcome to " + operatingSystem + " on " + model);
    }

    public void turnOff() {
        System.out.println("Turning off phone...");
    }
}
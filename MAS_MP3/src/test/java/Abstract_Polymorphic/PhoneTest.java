package Abstract_Polymorphic;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneTest {
    @Test
    public void testIOSPhone() {
        IOSPhone iPhone = new IOSPhone("iPhone X");

        // test inherited methods
        assertEquals(iPhone.model, "iPhone X");
        assertEquals(iPhone.operatingSystem, "iOS");
        assertFalse(iPhone.isCharging);
        assertEquals(iPhone.batteryLevel, 100);

        // test overridden methods
        iPhone.call("555-1234");
        iPhone.sendMessage("555-1234", "Hello!");
        iPhone.browseWeb("www.google.com");
        iPhone.takePhoto();
        iPhone.charge();
        assertEquals(iPhone.batteryLevel, 100);
        iPhone.checkBatteryLevel();
        iPhone.turnOn();
        iPhone.turnOff();
    }

    @Test
    public void testAndroidPhone() {
        AndroidPhone galaxy = new AndroidPhone("Galaxy S10");

        // test inherited methods
        assertEquals(galaxy.model, "Galaxy S10");
        assertEquals(galaxy.operatingSystem, "Android");
        assertFalse(galaxy.isCharging);
        assertEquals(galaxy.batteryLevel, 100);

        // test overridden methods
        galaxy.call("555-5678");
        galaxy.sendMessage("555-5678", "Hi!");
        galaxy.browseWeb("www.yahoo.com");
        galaxy.takePhoto();
        galaxy.charge();
        assertEquals(galaxy.batteryLevel, 100);
        galaxy.checkBatteryLevel();
        galaxy.turnOn();
        galaxy.turnOff();
    }
}
package Abstract_Polymorphic;

public class IOSPhone extends Phone {

    public IOSPhone(String model) {
        super(model, "iOS");
    }

    @Override
    public void call(String phoneNumber) {
        System.out.println("Calling " + phoneNumber + " on an iOS phone");
    }

    @Override
    public void sendMessage(String phoneNumber, String message) {
        System.out.println("Sending message \"" + message + "\" to " + phoneNumber + " on an iOS phone");
    }

    @Override
    public void browseWeb(String url) {
        System.out.println("Browsing " + url + " on an iOS phone");
    }

    @Override
    public void takePhoto() {
        System.out.println("Taking a photo on an iOS phone");
    }
}

package Abstract_Polymorphic;

public class AndroidPhone extends Phone {
    public AndroidPhone(String model) {
        super(model, "Android");
    }

    @Override
    public void call(String phoneNumber) {
        System.out.println("Calling " + phoneNumber + " on an Android phone");
    }

    @Override
    public void sendMessage(String phoneNumber, String message) {
        System.out.println("Sending message \"" + message + "\" to " + phoneNumber + " on an Android phone");
    }

    @Override
    public void browseWeb(String url) {
        System.out.println("Browsing " + url + " on an Android phone");
    }

    @Override
    public void takePhoto() {
        System.out.println("Taking a photo on an Android phone");
    }
}
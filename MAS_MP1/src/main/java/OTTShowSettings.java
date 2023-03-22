import java.io.Serializable;

public class OTTShowSettings implements Serializable {
    private  boolean isNotAvailable;
    private boolean isPurchased;

    public OTTShowSettings(boolean isNotAvailable, boolean isPurchased) {
        this.isNotAvailable = isNotAvailable;
        this.isPurchased = isPurchased;
    }

    public boolean getIsNotAvailable() {
        return isNotAvailable;
    }

    public void setNotAvailable(boolean notAvailable) {
        isNotAvailable = notAvailable;
    }

    public boolean getIsPurchased() {
        return isPurchased;
    }

    public void setPurchased(boolean purchased) {
        isPurchased = purchased;
    }

    @Override
    public String toString() {
        return "OTTShowSettings{" +
                "isNotAvailable=" + isNotAvailable +
                ", isPurchased=" + isPurchased +
                '}';
    }
}

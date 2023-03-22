package xor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PaidChannel {
    private String name;
    private List<Subscription> subscriptions = new ArrayList<>();

    public PaidChannel(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name Cannot be null or Empty");
        }
        this.name = name;
    }

    public List<Subscription> getSubscription() {
        return Collections.unmodifiableList(subscriptions);
    }

    public void addSubscription(Subscription subscription) {
        if (subscription.getFreeChannels().isEmpty()) {
            subscriptions.add(subscription);
            subscription.addPaidChannel(this);
        } else {
            throw new RuntimeException("A subscription cannot have both a paid channel and free channels.");
        }
    }

    public void removeSubscription(Subscription subscription) {
        if (subscriptions.contains(subscription)) {
            subscriptions.remove(subscription);
            subscription.removePaidChannel(this);
        }
    }
}

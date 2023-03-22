package xor;

import java.util.*;

public class Subscription {
    private String name;
    private List<FreeChannel> freeChannels = new ArrayList<>();
    private List<PaidChannel> paidChannels = new ArrayList<>();

    public Subscription(String name) {
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

    public List<FreeChannel> getFreeChannels() {
        return Collections.unmodifiableList(freeChannels);
    }

    public List<PaidChannel> getPaidChannel() {
        return Collections.unmodifiableList(paidChannels);
    }

    public void addFreeChannel(FreeChannel freeChannel) {
        if (paidChannels.isEmpty()) {
            freeChannels.add(freeChannel);
        } else {
            throw new RuntimeException("A subscription cannot have both a paid channel and free channels.");
        }
    }

    public void removeFreeChannel(FreeChannel freeChannel) {
        if (freeChannels.contains(freeChannel)) {
            freeChannels.remove(freeChannel);
        }else {
            throw new IllegalArgumentException("Provided channel does not exists");
        }
    }

    public void addPaidChannel(PaidChannel paidChannel) {
        if (freeChannels.isEmpty()) {
            paidChannels.add(paidChannel);
        } else {
            throw new RuntimeException("A subscription cannot have both a paid channel and free channels.");
        }
    }

    public void removePaidChannel(PaidChannel paidChannel) {
        if(paidChannels.contains(paidChannel)){
            paidChannels.remove(paidChannel);
        }else {
            throw new IllegalArgumentException("Provided channel does not exists");
        }
    }

}

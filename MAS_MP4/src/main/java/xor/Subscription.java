package xor;

import java.util.*;

public class Subscription {
    private String name;
    private final List<FreeChannel> freeChannels = new ArrayList<>();
    private final List<PaidChannel> paidChannels = new ArrayList<>();

    public Subscription(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
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
        if (freeChannel == null)
            throw new IllegalArgumentException("Free Channel must not be null");
        if (!paidChannels.isEmpty())
            throw new RuntimeException("A subscription cannot have both a paid channel and free channels.");
        freeChannels.add(freeChannel);
    }

    public void addPaidChannel(PaidChannel paidChannel) {
        if (paidChannel == null)
            throw new IllegalArgumentException("paid Channel must not be null");
        if (!freeChannels.isEmpty())
            throw new RuntimeException("A subscription cannot have both a paid channel and free channels.");
        paidChannels.add(paidChannel);
    }

    public void removeFreeChannel(FreeChannel freeChannel) {
        if (freeChannel == null)
            throw new IllegalArgumentException("Free Channel must not be null");
        if (!freeChannels.contains(freeChannel))
            throw new IllegalArgumentException("Provided channel does not exists");
        freeChannels.remove(freeChannel);
    }

    public void removePaidChannel(PaidChannel paidChannel) {
        if (paidChannel == null)
            throw new IllegalArgumentException("paid Channel must not be null");
        if (!paidChannels.contains(paidChannel))
            throw new IllegalArgumentException("Provided channel does not exists");
        paidChannels.remove(paidChannel);
    }

    public void clearFreeChannels() {
        freeChannels.clear();
    }

    public void clearPaidChannels() {
        paidChannels.clear();
    }
}

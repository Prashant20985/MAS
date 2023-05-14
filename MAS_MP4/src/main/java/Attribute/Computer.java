package Attribute;

public class Computer {
    private String model;
    private int ssdCapacity;
    private int ram;
    private int maxRamCapacity;

    public Computer(String model, int ssdCapacity, int ram, int maxRamCapacity) {
        setModel(model);
        setSsdCapacity(ssdCapacity);
        setMaxRamCapacity(maxRamCapacity);
        setRam(ram);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if (model == null || model.isBlank())
            throw new IllegalArgumentException("Model should not be blank or bull");
        this.model = model;
    }

    public int getSsdCapacity() {
        return ssdCapacity;
    }

    public void setSsdCapacity(int ssdCapacity) {
        if (ssdCapacity < 0)
            throw new IllegalArgumentException("SSD capacity cannot be less than 0");
        this.ssdCapacity = ssdCapacity;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        if (ram < 0)
            throw new IllegalArgumentException("Ram cannot ba less than 0");
        if (ram > this.maxRamCapacity)
            throw new IllegalArgumentException("Ram cannot be more than specified spec");
        this.ram = ram;
    }

    public int getMaxRamCapacity() {
        return maxRamCapacity;
    }

    public void setMaxRamCapacity(int maxRamCapacity) {
        if (maxRamCapacity < 0)
            throw new IllegalArgumentException("Max Ram Capacity cannot ba less than 0");
        this.maxRamCapacity = maxRamCapacity;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "model='" + model + '\'' +
                ", ssdCapacity=" + ssdCapacity +
                ", ram=" + ram +
                ", maxRamCapacity=" + maxRamCapacity +
                '}';
    }
}

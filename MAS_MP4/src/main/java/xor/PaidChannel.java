package xor;

public class PaidChannel {
    private String name;

    public PaidChannel(String name) {
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

    @Override
    public String toString() {
        return "PaidChannel{" +
                "name='" + name + '\'' +
                '}';
    }
}

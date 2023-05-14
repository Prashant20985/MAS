package xor;

public class FreeChannel {
    private String name;

    public FreeChannel(String name) {
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
        return "FreeChannel{" +
                "name='" + name + '\'' +
                '}';
    }
}

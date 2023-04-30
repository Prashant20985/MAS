package Multi_Inheritance;

public abstract class AbstractShape implements Shape {
    protected String name;

    public AbstractShape(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name must not be blank or null");
        this.name = name;
    }

    @Override
    public String toString() {
        return "AbstractShape{" +
                "name='" + name + '\'' +
                "area='" + getArea() + '\'' +
                '}';
    }
}

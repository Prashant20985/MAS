package Dynamic;

abstract public class Employee {
    private String name;

    public Employee(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or Blank");
        this.name = name;
    }

    public abstract double calculateSalary();
}

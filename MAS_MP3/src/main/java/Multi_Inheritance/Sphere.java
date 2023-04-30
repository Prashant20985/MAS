package Multi_Inheritance;

public class Sphere extends AbstractShape implements ThreeDShape {
    private double radius;

    public Sphere(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double getSurfaceArea() {
        return getArea();
    }

    @Override
    public double getVolume() {
        return 4.0 / 3.0 * Math.PI * radius * radius * radius;
    }
}

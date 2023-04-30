package Multi_Inheritance;

public class Cube extends AbstractShape implements ThreeDShape {
    private double side;

    public Cube(String name, double side) {
        super(name);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double getArea() {
        return 6 * side * side;
    }

    @Override
    public double getSurfaceArea() {
        return getArea();
    }

    @Override
    public double getVolume() {
        return side * side * side;
    }
}

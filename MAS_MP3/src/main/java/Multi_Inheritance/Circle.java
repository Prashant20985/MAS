package Multi_Inheritance;

public class Circle extends AbstractShape implements TwoDShape {
    private double radius;

    public Circle(String name, double radius) {
        super(name);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getParameter() {
        return Math.PI * radius * 2;
    }
}

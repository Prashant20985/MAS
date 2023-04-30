package Multi_Inheritance;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle("Circle", 5);
        Rectangle rectangle = new Rectangle("Rectangle", 4, 6);
        Sphere sphere = new Sphere("Sphere", 4);
        Cube cube = new Cube("Cube", 4);

        // call methods on Circle
        System.out.println(circle.getName());
        System.out.println(circle.getArea());
        System.out.println(circle.getParameter());

        // call methods on Rectangle
        System.out.println(rectangle.getName());
        System.out.println(rectangle.getArea());
        System.out.println(rectangle.getParameter());

        // call methods on Sphere
        System.out.println(sphere.getName());
        System.out.println(sphere.getArea());
        System.out.println(sphere.getSurfaceArea());
        System.out.println(sphere.getVolume());

        // call methods on Cube
        System.out.println(cube.getName());
        System.out.println(cube.getArea());
        System.out.println(cube.getSurfaceArea());
        System.out.println(cube.getVolume());
    }
}

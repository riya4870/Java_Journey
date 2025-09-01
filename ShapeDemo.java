// Sealed abstract class: only permits Circle, Rectangle, and Triangle to extend it
sealed abstract class Shape permits Circle, Rectangle, Triangle {
    // Abstract method to calculate area — subclasses must implement
    public abstract double area();
}

// Final subclass representing a circle
final class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // Override area calculation specific to circle
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

// Final subclass representing a rectangle
final class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Override area calculation specific to rectangle
    @Override
    public double area() {
        return width * height;
    }
}

// Final subclass representing a triangle
final class Triangle extends Shape {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    // Override area calculation specific to triangle
    @Override
    public double area() {
        return 0.5 * base * height;
    }
}

public class ShapeDemo {
    // Helper method uses pattern matching to print shape info and area
    static void printShapeInfo(Shape shape) {
        if (shape instanceof Circle c) {
            System.out.println("Circle area: " + c.area());
        } else if (shape instanceof Rectangle r) {
            System.out.println("Rectangle area: " + r.area());
        } else if (shape instanceof Triangle t) {
            System.out.println("Triangle area: " + t.area());
        } else {
            System.out.println("Unknown shape!");
        }
    }

    // Main method: creates shape objects and prints their areas
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);
        Shape triangle = new Triangle(3, 4);

        printShapeInfo(circle);
        printShapeInfo(rectangle);
        printShapeInfo(triangle);
    }
}



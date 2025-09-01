import java.util.Scanner;

public record Point(double x, double y) {

    public double distance(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x coordinate of point 1: ");
        double x1 = sc.nextDouble();
        System.out.print("Enter y coordinate of point 1: ");
        double y1 = sc.nextDouble();

        System.out.print("Enter x coordinate of point 2: ");
        double x2 = sc.nextDouble();
        System.out.print("Enter y coordinate of point 2: ");
        double y2 = sc.nextDouble();

        Point p1 = new Point(x1, y1);
        Point p2 = new Point(x2, y2);

        System.out.println("Point 1: " + p1);
        System.out.println("Point 2: " + p2);

        double distance = p1.distance(p2);
        System.out.printf("Distance between points: %.4f%n", distance);

        sc.close();
    }
}



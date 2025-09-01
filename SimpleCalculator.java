import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = sc.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = sc.nextDouble();

        System.out.print("Enter operator (+, -, *, /): ");
        char operator = sc.next().charAt(0);

        // Using switch expression
        double result = switch (operator) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> {
                if (num2 == 0) {
                    System.out.println("Cannot divide by zero!");
                    yield Double.NaN; // yield a value for the switch
                } else {
                    yield num1 / num2;
                }
            }
            default -> {
                System.out.println("Invalid operator!");
                yield Double.NaN;
            }
        };

        if (!Double.isNaN(result)) {
            System.out.println("Result: " + result);
        }

        sc.close();
    }
}


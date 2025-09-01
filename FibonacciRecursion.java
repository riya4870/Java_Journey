import java.util.Scanner;

public class FibonacciRecursion {
    // Recursive method
    public static int fib(int n) {
        if (n == 0) return 0;   // base case
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number n: ");
        int n = sc.nextInt();

        System.out.println("Fibonacci series up to " + n + ":");

        for (int i = 0; i <= n; i++) {
            System.out.print(fib(i) + " ");
        }
    }
}


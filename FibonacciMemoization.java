import java.util.Scanner;
import java.util.Arrays;

public class FibonacciMemoization {
    static int[] dp; // array to store computed values

    // Recursive method with memoization
    public static int fib(int n) {
        if (n == 0) return 0;   // base case
        if (n == 1) return 1;   // base case

        // If value already calculated, return it
        if (dp[n] != -1) return dp[n];

        // Otherwise calculate and store in dp
        dp[n] = fib(n - 1) + fib(n - 2);
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number n: ");
        int n = sc.nextInt();

        // Initialize dp array with -1 (meaning not calculated yet)
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println("Fibonacci series up to " + n + ":");

        for (int i = 0; i <= n; i++) {
            System.out.print(fib(i) + " ");
        }
    }
}


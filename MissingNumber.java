import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array (n-1): ");
        int n = sc.nextInt(); // array has n-1 elements
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements (from 1 to " + (n + 1) + "):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int totalSum = (n + 1) * (n + 2) / 2; // sum of 1 to n+1
        int arraySum = 0;
        for (int num : arr) {
            arraySum += num;
        }

        int missing = totalSum - arraySum;
        System.out.println("Missing number is: " + missing);

        sc.close();
    }
}


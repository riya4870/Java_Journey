import java.util.Scanner;
import java.util.Arrays;

public class ArrayRotation {

    // Helper method to reverse part of the array
    public static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    // Rotate array k times to the right
    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n; // handle k > n

        // Reverse entire array
        reverse(arr, 0, n - 1);
        // Reverse first k elements
        reverse(arr, 0, k - 1);
        // Reverse remaining elements
        reverse(arr, k, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter number of rotations k: ");
        int k = sc.nextInt();

        rotate(arr, k);

        System.out.println("Rotated array:");
        System.out.println(Arrays.toString(arr));

        sc.close();
    }
}


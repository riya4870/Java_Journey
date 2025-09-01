import java.util.Scanner;

public class BinaryToDecimal {
    public static int binaryToDecimal(String binary) {
        int decimal = 0;
        int power = 0;

        // start from rightmost digit
        for (int i = binary.length() - 1; i >= 0; i--) {
            int bit = binary.charAt(i) - '0'; // convert char to int
            decimal += bit * Math.pow(2, power);
            power++;
        }

        return decimal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a binary number: ");
        String binary = sc.nextLine();

        int decimal = binaryToDecimal(binary);

        System.out.println("Binary " + binary + " = Decimal " + decimal);

        sc.close();
    }
}


import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PhoneNumberValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        // Regex pattern for Indian phone numbers
        String regex = "^(\\+91|0)?[6-9]\\d{9}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phone);

        if (matcher.matches()) {
            System.out.println("Valid phone number!");
        } else {
            System.out.println("Invalid phone number!");
        }

        sc.close();
    }
}


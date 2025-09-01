import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        // Create a HashMap to store character frequencies
        Map<Character, Integer> freqMap = new HashMap<>();

        // Loop through each character
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ' ') continue; // ignore spaces

            if (freqMap.containsKey(ch)) {
                // If character already exists, increment its count
                freqMap.put(ch, freqMap.get(ch) + 1);
            } else {
                // If character appears first time, set count to 1
                freqMap.put(ch, 1);
            }
        }

        // Print the character frequencies
        System.out.println("Character frequencies:");
        for (char ch : freqMap.keySet()) {
            System.out.println(ch + " -> " + freqMap.get(ch));
        }

        sc.close();
    }
}


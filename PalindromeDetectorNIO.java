import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class PalindromeDetectorNIO {
    public static void main(String[] args) {
        String filePath = "data.txt";

        try (RandomAccessFile file = new RandomAccessFile(filePath, "r");
             FileChannel channel = file.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
            channel.read(buffer);

            buffer.flip();
            String content = new String(buffer.array());

            // Split on non-alphabetic characters
            String[] words = content.split("[^a-zA-Z]+");

            System.out.println("Palindrome words found:");
            for (String word : words) {
                if (!word.isEmpty() && isPalindrome(word)) {
                    System.out.println(word);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isPalindrome(String word) {
        word = word.toLowerCase();
        int left = 0, right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}


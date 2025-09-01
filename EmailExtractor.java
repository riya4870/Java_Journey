import java.util.regex.*;
import java.util.*;

public class EmailExtractor {
    public static void main(String[] args) {
        String text = "Here are some emails: test@example.com, hello.world@domain.org, user123@company.co.in";

        // Regex for email
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        System.out.println("Extracted Emails:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}


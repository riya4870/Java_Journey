import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {

    // Method to check if parentheses are balanced
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            // If opening bracket, push to stack
            if (ch == '(') {
                stack.push(ch);
            }
            // If closing bracket, check top of stack
            else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;  // No matching opening bracket
                }
                stack.pop();
            }
            // You can add more bracket types here if needed
        }

        // If stack is empty, all opening brackets had matching closing brackets
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an expression: ");
        String expr = scanner.nextLine();

        if (isBalanced(expr)) {
            System.out.println("Parentheses are balanced.");
        } else {
            System.out.println("Parentheses are NOT balanced.");
        }

        scanner.close();
    }
}


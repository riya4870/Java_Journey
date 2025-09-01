import java.util.Scanner;

// Logic class (not public)
class GradeClassifier {
    // Method to classify grade based on marks
    public String classify(int marks) {
        return switch (marks / 10) {
            case 10, 9 -> "A (Excellent)";
            case 8 -> "B (Very Good)";
            case 7 -> "C (Good)";
            case 6 -> "D (Average)";
            case 5 -> "E (Pass)";
            default -> "F (Fail)";
        };
    }
}

// Main runner class (public)
class MainRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter marks (0-100): ");
        int marks = sc.nextInt();

        // Create object of GradeClassifier and call method
        GradeClassifier classifier = new GradeClassifier();
        String grade = classifier.classify(marks);

        System.out.println("Your grade is: " + grade);
    }
}


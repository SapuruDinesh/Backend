package firsrqst;
import java.util.Scanner;

public class StringOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();

        System.out.println("Choose an operation:");
        System.out.println("1. Extract Substring");
        System.out.println("2. Split a Sentence");
        int choice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character left by nextInt()

        switch (choice) {
            case 1:
                extractSubstring(scanner, inputString);
                break;
            case 2:
                splitSentence(inputString);
                break;
            default:
                System.out.println("Invalid choice. Please choose 1 or 2.");
        }

        scanner.close();
    }

    private static void extractSubstring(Scanner scanner, String inputString) {
        boolean validInput = false;
        int startIndex = 0;
        int endIndex = 0;

        while (!validInput) {
            System.out.println("Enter the starting index:");
            startIndex = scanner.nextInt();
            System.out.println("Enter the ending index:");
            endIndex = scanner.nextInt();

            if (startIndex >= 0 && endIndex < inputString.length() && startIndex <= endIndex) {
                validInput = true;
            } else {
                System.out.println("Invalid indices. Please enter valid indices.");
            }
        }

        String substring = inputString.substring(startIndex, endIndex + 1);
        System.out.println("Extracted Substring: " + substring);
    }

    private static void splitSentence(String inputString) {
        String[] words = inputString.split("\\s+");
        System.out.println("Splitted words:");
        for (String word : words) {
            System.out.println(word);
        }
    }
}

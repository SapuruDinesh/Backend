package com.backend;
import java.util.Scanner;
public class SecondQuestion2A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();
        System.out.print("Enter starting index: ");
        int startIndex = scanner.nextInt();
        System.out.print("Enter ending index: ");
        int endIndex = scanner.nextInt();
        String substring = extractSubstring(inputString, startIndex, endIndex);
        if (substring != null) {
            System.out.println("Extracted substring: " + substring);
        }
        scanner.close();
    }
    public static String extractSubstring(String inputString, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > inputString.length() || startIndex > endIndex) {
            System.out.println("Invalid indices. Please try again.");
            return null;
        } else {
            return inputString.substring(startIndex, endIndex);
        }
    }
}

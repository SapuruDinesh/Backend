package com.backend;
import java.util.Scanner;
public class SecondQuestion2B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();
        String[] words = splitSentence(sentence);
        System.out.println("Splitted words are:");
        for (String word : words) {
            System.out.println(word);
        }
        scanner.close();
    }
    // Method to split the sentence into words
    public static String[] splitSentence(String sentence) {
        return sentence.split("\\s+");
    }
}

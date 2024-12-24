package com.backend;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
public class ThirdQuestion3 {
    private static List<String> list = new ArrayList<>();
    private static Set<String> set = new HashSet<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nCollection Management System");
            System.out.println("1. Use List");
            System.out.println("2. Use Set");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    manageList();
                    break;
                case 2:
                    manageSet();
                    break;
                case 3:
                    System.out.println("Exiting the system");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void manageList() {
        while (true) {
            System.out.println("\nUse List");
            System.out.println("1. Add an element");
            System.out.println("2. Remove an element");
            System.out.println("3. Display all elements");
            System.out.println("4. Back to main menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addToList();
                    break;
                case 2:
                    removeFromList();
                    break;
                case 3:
                    displayList();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void manageSet() {
        while (true) {
            System.out.println("\nUse Set");
            System.out.println("1. Add an element");
            System.out.println("2. Remove an element");
            System.out.println("3. Display all elements");
            System.out.println("4. Back to main menu");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addToSet();
                    break;
                case 2:
                    removeFromSet();
                    break;
                case 3:
                    displaySet();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void addToList() {
        System.out.print("Enter element to add: ");
        String elementToAdd = scanner.nextLine();
        list.add(elementToAdd);
        System.out.println("Element added to the list.");
    }
    private static void removeFromList() {
        System.out.print("Enter element to remove: ");
        String elementToRemove = scanner.nextLine();
        if (list.remove(elementToRemove)) {
            System.out.println("Element removed from the list.");
        } else {
            System.out.println("Element not found in the list.");
        }
    }
    private static void displayList() {
        System.out.println("List elements: " + list);
    }
    private static void addToSet() {
        System.out.print("Enter element to add: ");
        String elementToAdd = scanner.nextLine();
        if (set.add(elementToAdd)) {
            System.out.println("Element added to the set.");
        } else {
            System.out.println("Element already exists in the set.");
        }
    }
    private static void removeFromSet() {
        System.out.print("Enter element to remove: ");
        String elementToRemove = scanner.nextLine();
        if (set.remove(elementToRemove)) {
            System.out.println("Element removed from the set.");
        } else {
            System.out.println("Element not found in the set.");
        }
    }
    private static void displaySet() {
        System.out.println("Set elements: " + set);
    }
}

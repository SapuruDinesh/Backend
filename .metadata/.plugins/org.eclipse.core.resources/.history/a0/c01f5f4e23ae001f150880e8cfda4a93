package com.backend;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
class Employee {
    private int id;
    private String name;
    private int salary;
    private String department;
    public Employee(Scanner inputs) {
        System.out.println("Enter The Id Of The Employee: ");
        this.id = inputs.nextInt();
        System.out.println("Enter The Name: ");
        this.name = inputs.next();
        System.out.println("Enter The Salary: ");
        this.salary = inputs.nextInt();
        System.out.println("Enter The Department Name: ");
        this.department = inputs.next();
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary + ", Department: " + department;
    }
    public int getId() {
        return id;
    }
}

public class FourthQuestion4 {
    private static List<Map<Integer, Employee>> employeeList = new ArrayList<>();
    private static Map<Integer, Employee> employeeMap = new HashMap<>();
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWelcome To Employee Management System");
            System.out.println("Enter The choice from the options below:");
            System.out.println("1. Add Employee: A");
            System.out.println("2. Update Employee Details: U");
            System.out.println("3. Delete Employee Details: D");
            System.out.println("4. Display Employee Details: DE");
            System.out.println("5. Search Employee Details: S");
            System.out.println("6. Exit: E");
            String choice = input.next().toUpperCase();
            switch (choice) {
                case "A":
                    addEmployee();
                    break;
                case "U":
                    updateEmployee();
                    break;
                case "D":
                    deleteEmployee();
                    break;
                case "DE":
                    displayEmployee();
                    break;
                case "S":
                    searchEmployee();
                    break;
                case "E":
                    System.out.println("Exiting the system");
                    input.close();
                    return;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }
    }
    private static void addEmployee() {
        Employee employee = new Employee(input);
        employeeMap.put(employee.getId(), employee);
        employeeList.add(employeeMap);
        System.out.println("Employee added successfully.");
    }
    private static void updateEmployee() {
        System.out.println("Enter The Id Of Employee: ");
        int id = input.nextInt();
        if (employeeMap.containsKey(id)) {
            Employee updatedEmployee = new Employee(input);
            employeeMap.put(id, updatedEmployee);
            System.out.println("Employee updated successfully.");
        } else {
            System.out.println("Employee ID not found.");
        }
    }

    private static void deleteEmployee() {
        System.out.println("Enter The Id Of Employee: ");
        int id = input.nextInt();
        if (employeeMap.containsKey(id)) {
            employeeMap.remove(id);
            employeeList.removeIf(map -> map.containsKey(id));
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("The Employee With That Id Is Not Existed.");
        }
    }
    private static void displayEmployee() {
        System.out.println("Enter The Id Of Employee: ");
        int id = input.nextInt();
        if (employeeMap.containsKey(id)) {
            System.out.println(employeeMap.get(id));
        } else {
            System.out.println("The Employee With That Id Is Not Existed.");
        }
    }
    private static void searchEmployee() {
        System.out.println("Enter The Id Of Employee: ");
        int id = input.nextInt();
        if (employeeMap.containsKey(id)) {
            System.out.println(employeeMap.get(id));
        } else {
            System.out.println("The Employee With That Id Is Not Existed.");
        }
    }
}

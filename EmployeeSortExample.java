import java.util.*;
import java.util.stream.*;

public class EmployeeSortExample {

    // Employee class
    static class Employee {
        private String name;
        private double salary;

        // Constructor
        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        // Getters
        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        // toString for printing out employee details
        @Override
        public String toString() {
            return "Employee{name='" + name + "', salary=" + salary + "}";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask user for the number of employees
        System.out.print("Enter the number of employees: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextInt()

        List<Employee> employees = new ArrayList<>();

        // Collect employee details
        for (int i = 0; i < numEmployees; i++) {
            System.out.print("Enter name for employee " + (i + 1) + ": ");
            String name = scanner.nextLine();

            System.out.print("Enter salary for " + name + ": ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character left by nextDouble()

            employees.add(new Employee(name, salary));
        }

        // Sort employees by salary using Streams API
        List<Employee> sortedEmployees = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary)) // Sorting by salary
                .collect(Collectors.toList());

        // Print the sorted list
        System.out.println("\nSorted list of employees by salary:");
        sortedEmployees.forEach(System.out::println);

        scanner.close();
    }
}


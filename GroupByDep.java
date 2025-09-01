import java.util.*;
import java.util.stream.Collectors;

public class GroupByDep {

    // Employee class inside same file for simplicity
    static class Employee {
        private String name;
        private String department;

        public Employee(String name, String department) {
            this.name = name;
            this.department = department;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("How many employees? ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for employee #" + (i + 1));

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Department: ");
            String dept = scanner.nextLine();

            employees.add(new Employee(name, dept));
        }

        // Group employees by department using streams
        Map<String, List<Employee>> groupedByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // Print the result
        System.out.println("\nEmployees grouped by department:");
        groupedByDept.forEach((department, empList) -> {
            System.out.println(department + ": " + empList);
        });

        scanner.close();
    }
}


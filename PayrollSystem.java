import java.util.Scanner;

// Employee class
class Employee {
    private int id;
    private String name;
    private double basicSalary;

    // Constructor
    public Employee(int id, String name, double basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    // Calculate HRA (10% of basic)
    public double calculateHRA() {
        return basicSalary * 0.10;
    }

    // Calculate DA (5% of basic)
    public double calculateDA() {
        return basicSalary * 0.05;
    }

    // Calculate Gross Salary
    public double calculateGrossSalary() {
        return basicSalary + calculateHRA() + calculateDA();
    }

    // Display Employee Payroll
    public void displayPayroll() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("HRA: " + calculateHRA());
        System.out.println("DA: " + calculateDA());
        System.out.println("Gross Salary: " + calculateGrossSalary());
        System.out.println("--------------------------");
    }
}

// Main class
public class PayrollSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Employee " + (i + 1) + ":");
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // consume newline

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Basic Salary: ");
            double basic = sc.nextDouble();

            employees[i] = new Employee(id, name, basic);
            System.out.println();
        }

        System.out.println("Payroll Details:");
        for (Employee emp : employees) {
            emp.displayPayroll();
        }

        sc.close();
    }
}


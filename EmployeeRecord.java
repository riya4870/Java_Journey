import java.util.Scanner;

public class EmployeeRecord {
    // Define the immutable Employee record
    public record Employee(int id, String name, double salary) {
        // Custom method to display employee details
        public void display() {
            System.out.println("Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = sc.nextDouble();

        // Create immutable Employee object
        Employee emp = new Employee(id, name, salary);

        // Access and display fields
        System.out.println("ID: " + emp.id());
        System.out.println("Name: " + emp.name());
        System.out.println("Salary: " + emp.salary());

        // Use custom method
        emp.display();

        sc.close();
    }
}


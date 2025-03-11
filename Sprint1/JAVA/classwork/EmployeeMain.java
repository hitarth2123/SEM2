import java.util.Scanner;

class Employee {
    String name;
    int age;

    void display() {
        System.out.println("This is an employee");
    }

    void inputData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter employee name: ");
        name = scanner.nextLine();
        System.out.println("Enter employee age: ");
        age = scanner.nextInt();
        scanner.close();
    }

    void displayData() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Age: " + age);
    }
}

class Manager extends Employee {
    String department;

    void display() {
        System.out.println("This is a manager");
    }

    void inputData() {
        super.inputData();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter manager department: ");
        department = scanner.next();
        scanner.close();
    }

    void displayData() {
        super.displayData();
        System.out.println("Manager Department: " + department);
    }
}

public class EmployeeMain {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.inputData();
        manager.display();
        manager.displayData();
    }
}

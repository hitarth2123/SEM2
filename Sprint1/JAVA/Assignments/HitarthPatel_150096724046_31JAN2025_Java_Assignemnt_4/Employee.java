import java.util.Scanner;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Employee() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary() {
        return salary * 12;
    }

    public void raiseSalary(double percent) {
        this.salary += this.salary * (percent / 100);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee employee = new Employee();

        System.out.println("Enter Employee ID: ");
        employee.setId(scanner.nextInt());
        scanner.nextLine(); // Consume newline left-over

        System.out.println("Enter Employee First Name: ");
        employee.setFirstName(scanner.nextLine());

        System.out.println("Enter Employee Last Name: ");
        employee.setLastName(scanner.nextLine());

        System.out.println("Enter Employee Monthly Salary: ");
        employee.setSalary(scanner.nextInt());

        System.out.println("Employee ID: " + employee.getId());
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Employee Monthly Salary: " + employee.getSalary());
        System.out.println("Employee Annual Salary: " + employee.getAnnualSalary());

        System.out.println("Enter percentage to raise salary: ");
        double percent = scanner.nextDouble();
        employee.raiseSalary(percent);

        System.out.println("Employee Monthly Salary after raise: " + employee.getSalary());
        System.out.println("Employee Annual Salary after raise: " + employee.getAnnualSalary());

        scanner.close();
    }
}






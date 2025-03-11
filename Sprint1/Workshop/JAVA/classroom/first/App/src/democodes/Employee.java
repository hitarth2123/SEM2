package democodes;
public class Employee {
    int employeeId;
    String employeName;
    double salary;
    float age;

    public void displayData()
    {
        System.out.println("Employee details ");
        System.out.println(employeeId+" "+employeName+" "+salary+" "+age);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee();
        e1.employeeId=10;
        e1.employeName="Radha";
        e1.salary=20000.35;
        e1.age=22;

        e1.displayData();
    }


}
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Employee {
    String name;
    int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return name + " - " + salary;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 5000));
        employees.add(new Employee("Bob", 7000));
        employees.add(new Employee("Charlie", 6000));

        Collections.sort(employees, Comparator.comparingInt(e -> e.salary));

        for (Employee e : employees) {
            System.out.println(e);
        }
    }
}

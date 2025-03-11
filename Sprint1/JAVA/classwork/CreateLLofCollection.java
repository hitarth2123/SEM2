import java.util.*;

class Student {
    String name;
    double marks;

    public Student(String s, double m) {
        name = s;
        marks = m;
    }

    public void printData() {
        System.out.print("Name : " + name);
        System.out.println(" Marks : " + marks);
    }
}

public class CreateLLofCollection {
    public static void main(String args[]) {
        Student sArray[] = new Student[5];

        sArray[0] = new Student("Ram", 79.6);
        sArray[1] = new Student("Rahim", 85.5);
        sArray[2] = new Student("John", 90.1);
        sArray[3] = new Student("Lisa", 69.4);
        sArray[4] = new Student("Ana", 59.8);

        LinkedList<Student> ll = new LinkedList<Student>(Arrays.asList(sArray));
        Student temp;

        Iterator<Student> itr = ll.iterator();
        while (itr.hasNext()) {
            temp = itr.next();
            temp.printData();
        }
    }
}


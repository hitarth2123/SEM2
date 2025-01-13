import java.util.Scanner;

class StudentPerformanceTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name = "";
        int roll = 0;
        String result = "";
        while (true) {
            System.out.println("\n1. Add Student");   
            System.out.println("\n2. Display Student");
            System.out.println("\n3. Exit");
            System.out.print("\nEnter your choice: ");
            int a = sc.nextInt();
            switch (a) {
                case 1:
                    System.out.print("\nEnter the name of student: ");
                    name = sc.next();
                    System.out.print("\nEnter the roll number of student: ");
                    roll = sc.nextInt();
                    System.out.print("\nEnter the marks of student in Python: ");
                    int Python = sc.nextInt();
                    System.out.print("\nEnter the marks of student in C++: ");
                    int CPlusPlus = sc.nextInt();
                    System.out.print("\nEnter the marks of student in CSF: ");
                    int CSF = sc.nextInt();
                    int avg = (Python + CPlusPlus + CSF) / 3;
                
                    if (Python >= 40 && CPlusPlus >= 40 && CSF >= 40 && avg >= 50) {
                        result = "Pass";
                    } else {
                        result = "Fail";
                    }
                    break;
                case 2:
                    if (result.equals("Pass")) {
                        System.out.println("\nThe student Name :- " + name + "\nRoll no :- " + roll + "\nResult :- Passed");
                    } else {
                        System.out.println("\nThe student Name :- " + name + "\nRoll no :- " + roll + "\nResult :- Failed");
                    }
                    break;
                case 3:
                    System.out.println("\nExiting Application"+"\n");
                    sc.close();
                    return;
                default:
                    System.out.println("\nInvalid choice. Please select 1, 2, or 3.");
                    break;
           }
        }
    }
}   


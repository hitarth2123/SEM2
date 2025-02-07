import java.util.Scanner;

public class SumEx1 {
    public int sum(int a, int b) {
        return a + b;
    }

    public int sum(int a, int b, int c) {
        return a + b + c;
    }

    public double sum(double a, double b) {
        return a + b;
    }

    public double sum(double a, double b, double c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        SumEx1 sumEx1 = new SumEx1();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter two integers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("Sum of two integers: " + sumEx1.sum(a, b));

        System.out.println("Enter three integers: ");
        a = scanner.nextInt();
        b = scanner.nextInt();
        int c = scanner.nextInt();
        System.out.println("Sum of three integers: " + sumEx1.sum(a, b, c));

        System.out.println("Enter two doubles: ");
        double d = scanner.nextDouble();
        double e = scanner.nextDouble();
        System.out.println("Sum of two doubles: " + sumEx1.sum(d, e));

        System.out.println("Enter three doubles: ");
        d = scanner.nextDouble();
        e = scanner.nextDouble();
        double f = scanner.nextDouble();
        System.out.println("Sum of three doubles: " + sumEx1.sum(d, e, f));

        scanner.close();
    }
}

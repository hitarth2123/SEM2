import java.util.Scanner;

public class adddigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to add its digits: ");
        int number = sc.nextInt();
        int sum = 0;
        for (; number != 0; number /= 10) {
            int digit = number % 10;
            sum += digit;
        }
        System.out.println("The sum of the digits is: " + sum);
        sc.close();
    }
}

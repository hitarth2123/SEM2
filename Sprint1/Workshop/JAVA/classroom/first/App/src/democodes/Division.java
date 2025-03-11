package democodes;

import java.util.Scanner;

public class Division {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number:");
        int num1 = scanner.nextInt();
        System.out.println("Enter the second number:");
        int num2 = scanner.nextInt();

        int result = num1 / num2;
        System.out.println("The result of floor division is: " + result);
        scanner.close();
    }
}

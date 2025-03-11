import java.util.Scanner;

public class reverloop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number to reverse its digits: ");
        int number = sc.nextInt();
        int reversed = 0;
        for (; number != 0; number /= 10) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
        }
        System.out.println("The reverse of the number is: " + reversed);
        sc.close();
    }
}

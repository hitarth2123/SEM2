import java.util.Scanner;
class SumIntegerNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        long num = sc.nextLong();
        long sum = 0;
        long totalsum = 0;
        while(num != 0) {
            long digit = num % 10;
            sum = sum + digit;
            num /= 10;
            totalsum = sum;
        }
        System.out.println("Sum of the digits: " + totalsum);
        sc.close();
    }
    
}

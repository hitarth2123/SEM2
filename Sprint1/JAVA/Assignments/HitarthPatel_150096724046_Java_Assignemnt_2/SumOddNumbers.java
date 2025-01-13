import java.util.Scanner;
class SumOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first and last number: ");
        int first = scanner.nextInt();
        int last = scanner.nextInt();
        int sum = 0;
        for(int i = first; i <= last; i++) {
            if(i % 2 != 0) {
                sum += i;
            }
            System.out.println("Sum of odd numbers between " + first + " and " + last + " is " + sum);
        }
        scanner.close();
    }
}

import java.util.Scanner;

class factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to calculate its factorial: ");
        int number = scanner.nextInt();
        long factorial = calculateFactorial(number);
        System.out.println("Factorial of " + number + " is " + factorial);
        scanner.close();
    }

    private static long calculateFactorial(int number) {
        if(number == 0) {
            return 1;
        } else {
            return number * calculateFactorial(number - 1);
        }
    }
}

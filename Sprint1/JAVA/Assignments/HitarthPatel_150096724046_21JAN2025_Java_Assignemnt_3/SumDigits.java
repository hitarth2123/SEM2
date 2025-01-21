import java.util.Scanner;

public class SumDigits {
   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        int sum = 0;
        
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Integer.parseInt(String.valueOf(c));
            }
        }
        System.out.println("Sum of digits in the string: " + sum);
        scanner.close();
    }
}

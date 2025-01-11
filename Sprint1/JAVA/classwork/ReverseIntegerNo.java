import java.util.Scanner;
class ReverseIntegerNo {
   public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int num = sc.nextInt();
    int reversed = 0;
    int rev = 0;
    while(num != 0) {
        int digit = num % 10;
        reversed = reversed * 10 + digit;
        num /= 10;
        rev= reversed;
    }
    System.out.println("Reversed Number: " + rev);
    sc.close();
   } 
}

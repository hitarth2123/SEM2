import java.util.Scanner;
class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = sc.nextInt();
        int originalNum, remainder, result = 0;
        originalNum = num;
        while (originalNum != 0) {
            remainder = originalNum % 10;
            result += Math.pow(remainder, 3);
            originalNum /= 10;
        }
        if (result == num)
            System.out.println(num + " is an Armstrong number.");
        else
            System.out.println(num + " is not an Armstrong number.");
        sc.close();
    }

   
}

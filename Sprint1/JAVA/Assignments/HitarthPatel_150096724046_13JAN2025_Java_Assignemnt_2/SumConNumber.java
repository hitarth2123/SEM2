import java.util.Scanner;
class SumConNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of n: ");
        int n = sc.nextInt();
        int oddSum = 0;
        int evenSum = 0;
        int oddCount = 0;
        int evenCount = 0;
        int i = 1;
        while(oddCount < n || evenCount < n) {
            if(i % 2 != 0) {
                oddSum += i;
                oddCount++;
            } else {
                evenSum += i;
                evenCount++;
            }
            i++;
        }
        System.out.println("Average of first " + n + " odd numbers: " + (oddSum / n));
        System.out.println("Average of first " + n + " even numbers: " + (evenSum / n));

        sc.close();
        }
        
      
    
}

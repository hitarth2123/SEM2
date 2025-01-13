import java.util.Scanner;
class PrimeNo {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter a number:");
    int num = sc.nextInt();
    boolean flag = false;
    for(int i = 2; i <= num/2; ++i){
        if(num % i == 0){
            flag = true;
            break;
        }
        }
        if(flag == true)
            System.out.println(num + " is not a prime number.");
        else
            System.out.println(num + " is a prime number.");
    sc.close();

    }
}

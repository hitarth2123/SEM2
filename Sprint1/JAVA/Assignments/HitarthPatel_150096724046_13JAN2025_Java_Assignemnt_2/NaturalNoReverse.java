import java.util.Scanner;
class NaturalNoReverse {
    public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
            System.out.println("Enter the first and last number: ");
            int first = sc.nextInt(); 
            int last = sc.nextInt();

            for(int i = last; i >= first; i--) {
                System.out.println(i);
            }

            sc.close();
   
    }
}
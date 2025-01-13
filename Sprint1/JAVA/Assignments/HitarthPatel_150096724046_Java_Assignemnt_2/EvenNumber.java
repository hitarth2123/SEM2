 import java.util.Scanner;
 class EvenNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first and last number: ");
        int first = sc.nextInt();
        int last = sc.nextInt();
        for(int i = first; i <= last; i++) {
            if(i % 2 == 0) {
                System.out.println(i);
            }
        }
        sc.close();
    }
}

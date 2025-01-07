import java.util.Scanner;
class ConditionalOperators{
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);

        
        System.out.println("Enter two integers :-");
        Integer  a =scanner.nextInt();
        Integer  b =scanner.nextInt();
        System.out.println((a>b)?"A is greater than B.":"B is greater than A"); 
        
        scanner.close();
    }
}
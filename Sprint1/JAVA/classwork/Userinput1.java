import java.util.Scanner;
class Userinput1 {
    public static void main(String[]args){
        Scanner hello =new Scanner(System.in);

        System.out.println("Enter an integer number ");
        Integer i=hello.nextInt();
        System.out.println("int i: "+i);

        System.out.println("Enter an float number ");
        Float f=hello.nextFloat();
        System.out.println("float f: "+f);

        System.out.println("Enter a double number ");
        Double d=hello.nextDouble();
        System.out.println("double d: "+d);

        System.out.println("Enter a string ");
        String s=hello.nextLine();
        System.out.println("String s: "+s);

        System.out.println("Enter a character ");
        char c =hello.next().charAt(0);
        System.out.println("char c: "+c);

        hello.close();
    }
    
}

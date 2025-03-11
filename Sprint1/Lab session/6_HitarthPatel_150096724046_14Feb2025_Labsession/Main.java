import java.util.Scanner;
class BasePrinter {
    void print(Object obj) {
        System.out.println("Object: " + obj);
    }
}

class IntegerPrinter extends BasePrinter {
    void print(Object obj) {
        System.out.println("Integer: " + obj);
    }
}

class StringPrinter extends BasePrinter {
    void print(Object obj) {
        System.out.println("String: " + obj);
    }
}

class FloatPrinter extends BasePrinter {
    void print(Object obj) {
        System.out.println("Float: " + obj);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BasePrinter printer = new BasePrinter();
        
        System.out.print("Enter an integer: ");
        int num = scanner.nextInt();
        printer.print(num);
        
        System.out.print("Enter a string: ");
        String text = scanner.next();
        printer.print(text);
        
        System.out.print("Enter a float: ");
        float floatNum = scanner.nextFloat();
        printer.print(floatNum);
        scanner.close();
    }
}



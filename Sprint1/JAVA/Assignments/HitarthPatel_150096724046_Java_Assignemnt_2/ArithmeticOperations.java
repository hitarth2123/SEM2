import java.util.Scanner;
class ArithmeticOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter two numbers: ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        System.out.println("Enter operation to perform (1 for Sum, 2 for Difference, 3 for Multiplication, 4 for Division, 5 for Modulus, q to quit): ");
        String choice = sc.next();
       first: do {
         second : 
         System.out.println("Do you want to continue? (yes/no): ");
            choice = sc.next();
            if (choice.equals("no")) {
                break first;
            }
            System.out.println("Enter operation to perform (1 for Sum, 2 for Difference, 3 for Multiplication, 4 for Division, 5 for Modulus, q to quit): ");
            String operation = sc.next();
           third: switch (operation) {
                case "1":
                    int sum = num1 + num2;
                    System.out.println("Sum: " + sum);

                    break third;
                case "2":
                    int diff = num1 - num2;
                    System.out.println("Difference: " + diff);
                    break;
                case "3":
                    int mul = num1 * num2;
                    System.out.println("Multiplication: " + mul);
                    break third;
                case "4":
                    if (num2 != 0) {
                        int div = num1 / num2;
                        System.out.println("Division: " + div);
                    } else {
                        System.out.println("Cannot divide by zero.");
                    }
                    break third;
                case "5":
                    int mod = num1 % num2;
                    System.out.println("Modulus: " + mod);
                    break;
                case "q":
                case "quit":
                    choice = "no";
                    break first;
                default:
                    System.out.println("Invalid operation. Please try again.");
            }
            if (!operation.equals("q") && !operation.equals("quit")) {
                System.out.println("Do you want to continue? (yes/no): ");
                choice = sc.next();
            }
        } while (choice.equals("yes"));


        sc.close();
        }

    
}

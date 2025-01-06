
 /*
   Task 2: Store Student Details
    Store:
    Name
    Roll Number
    Three subject marks
    */ 
    import java.util.Scanner;

    class Task4 {
        public static void main(String[]args){
            Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
            System.out.print("Enter your name : "); // Prompt user for their name
            String userName = scanner.nextLine(); // Read user name input
            System.out.println("You entered: " + userName); // Display the entered name
            System.out.println("Enter your roll no : "); // Prompt user for their roll number
            Integer userRollno =scanner.nextInt(); // Read user roll number input
            System.out.println("You Entered: "+ userRollno); // Display the entered roll number
            System.out.println("Enter your 3 subject marks : "); // Prompt user for subject marks
            Integer userMark1 =scanner.nextInt(); // Read first subject mark
            Integer userMark2 =scanner.nextInt(); // Read second subject mark
            Integer userMark3 =scanner.nextInt(); // Read third subject mark
            System.out.println("Your marks of 3 subject are: "+ userMark1+" "+ userMark2 +" "+ userMark3); // Display entered marks
         
            scanner.close(); // Close the scanner to prevent resource leaks
        }
    
      
    }

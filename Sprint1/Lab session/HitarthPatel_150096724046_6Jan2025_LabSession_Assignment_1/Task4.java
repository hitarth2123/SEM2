/*

Task 4: Show Results
Display:
All student details Total and Percentage Pass/Fail status
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
       
            Integer totalMarks = 0; // Initialize totalMarks
            totalMarks = userMark1 + userMark2 + userMark3; // Calculate total marks
            System.out.println("Your total score is "+totalMarks); // Display total score

            Integer percentage =0; // Initialize percentage
            percentage=totalMarks/3 ; // Calculate percentage
            System.out.println("Your percentage is :"+percentage); // Display percentage
            String result =""; // Initialize result
            if (percentage<40){ // Check if the percentage is less than 40
                 result="fail"; // Set result to fail
                 System.out.println(result); // Print fail message

            }
            else{ // If percentage is 40 or more
                 result ="pass"; // Set result to pass
                 System.out.println(result); // Print pass message

            }
            System.out.println(""); // Print a blank line
            System.out.println(""); // Print another blank line

            // Display student details
            System.out.println("Student Name :-" +userName); // Display student name
            System.out.println("Total marks obtained :-" +totalMarks); // Display total marks
            System.out.println("Percentage obtained :-" +percentage); // Display percentage
            System.out.println("Result :-" +result); // Display pass/fail result
         
            scanner.close(); // Close the scanner to prevent resource leaks
        }
    
      
    }
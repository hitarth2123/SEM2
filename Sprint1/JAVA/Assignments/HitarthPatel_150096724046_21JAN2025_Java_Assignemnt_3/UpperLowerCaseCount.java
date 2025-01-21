import java.util.Scanner;

public class UpperLowerCaseCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = scanner.nextLine();
        int upper = 0, lower = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                upper++;
            } else if (Character.isLowerCase(ch)) {
                lower++;
            }
        }

        System.out.println("Number of uppercase letters: " + upper);
        System.out.println("Number of lowercase letters: " + lower);
        
        scanner.close();
    }
}


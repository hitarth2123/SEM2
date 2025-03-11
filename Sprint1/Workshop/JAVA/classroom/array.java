import java.util.Scanner;
class array {
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of rows for the array: ");
    int rows = sc.nextInt();
    System.out.println("Enter the number of columns for the array: ");
    int columns = sc.nextInt();
    int[][] multiArray = new int[rows][columns];
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            System.out.println("Enter the value for array[" + i + "][" + j + "]: ");
            multiArray[i][j] = sc.nextInt();
        }
    }
    System.out.println("The user input for the multidimensional array is: ");
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            System.out.print(multiArray[i][j] + " ");
        }
        System.out.println();
    }
    
    sc.close();
 }
    
}

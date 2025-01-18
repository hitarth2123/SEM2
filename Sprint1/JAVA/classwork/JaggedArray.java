import java.util.Scanner;

class JaggedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows: ");
        int rows = scanner.nextInt();
        int two[][]= new int[rows][];
        for(int i=0; i<rows; i++) {
            System.out.println("Enter the number of columns for row " + (i+1) + ": ");
            int columns = scanner.nextInt();
            two[i] = new int[columns];
        }
        int k=0;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<two[i].length; j++) {
                two[i][j]=k;
                k++;
            }
        }
        for(int i=0; i<rows; i++) {
            for(int j=0; j<two[i].length; j++) {
                System.out.print(two[i][j]+" ");
            }
            System.out.println();
        }
        scanner.close();
    }

}

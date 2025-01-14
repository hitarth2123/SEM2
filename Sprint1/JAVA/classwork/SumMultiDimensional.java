import java.util.Scanner;
class SumMultiDimensional {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the number of rows : ");
        int rows = sc.nextInt();
        System.out.println("\nEnter the number of columns : ");
        int cols = sc.nextInt();
        int[][] arr = new int[rows][cols];
        int [][]arr1 =new int [rows][cols];
        System.out.println("\nEnter the elements of the first array : ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("\nEnter the elements of the second array : ");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                arr1[i][j]=sc.nextInt();
            }
        }
        
        int internalsum = 0;
        for (int i = 0; i < rows; i++) {
            for (int element : arr[i]) {
                internalsum += element;
            }
        }
        int internalsum1 = 0;
        for (int i = 0; i < rows; i++) {
            for (int element : arr1[i]) {
                internalsum1 += element;
            }
        }
        int sum[][] =new int [rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                sum[i][j]=arr[i][j]+arr1[i][j];
            }
        }
        int j = 0;
        int avg = 0;
        for (int i = 0; i < rows; i++) {
            for (int element : arr[i]) {
                j += element;
                avg = j / (rows * cols);
            }
        }
        int j1 = 0;
        int avg1 = 0;
        for (int i = 0; i < rows; i++) {
            for (int element : arr1[i]) {
                j1 += element;
                avg1 = j1 / (rows * cols);
            }
        }
        System.out.println("\nSum of the elements of the first array : " + internalsum);
        System.out.println("\nSum of the elements of the second array : " + internalsum1);
        System.out.println("\nAverage of the elements of the first array : " + avg);
        System.out.println("\nAverage of the elements of the second array : " + avg1);
        System.out.println("\nSum of the elements of the array after adding the second array : ");

        for(int e=0;e<rows;e++){
            for(int f=0;f<cols;f++){
                System.out.print(sum[e][f]+" ");
            }
            System.out.println();
        }
        sc.close();
        }
    
}

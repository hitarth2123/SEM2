import java.util.Scanner;
class SumIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter a size of the array : ");
        int num = scanner.nextInt();
        int[] arr = new int[num];
        System.out.println("\nEnter the elements of the array : ");
        for (int i = 0; i < num; i++) {
            arr[i] = scanner.nextInt();
            }
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }
        int j = 0;
        int avg = 0;
        for(int i=0; i<num; i++){
                j += arr[i]; 
                avg = j/num;
        }
        System.out.println("\nSum of the elements of the array : " + sum);
        System.out.println("\nAverage of the elements of the array : " + avg);
        scanner.close();
        }

    
}

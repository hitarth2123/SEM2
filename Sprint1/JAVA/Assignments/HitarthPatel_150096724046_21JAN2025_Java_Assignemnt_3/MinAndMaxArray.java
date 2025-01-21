import java.util.Scanner;

public class MinAndMaxArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the elements of the array: ");
        for(int i=0; i < n; i++){
            array[i] = scanner.nextInt();
        }
        int max = array[0];
        int min = array[0];
        for(int i=1; i < array.length; i++){
            if(array[i] > max){
                max = array[i];
            }else if(array[i] < min){
                min = array[i];
            }
        }
        System.out.println("Maximum Value is : " + max);
        System.out.println("Minimum Value is : " + min);
        scanner.close();
    }
}


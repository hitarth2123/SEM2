import java.util.Scanner;
public class SpecificPositionAdd {
    public static void insertElement(int[] array, int position, int element) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, position);
        newArray[position] = element;
        System.arraycopy(array, position, newArray, position + 1, array.length - position);
        array = newArray;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array:");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.println("Enter the position where you want to insert the element:");
        int position = scanner.nextInt();
        System.out.println("Enter the element you want to insert:");
        int element = scanner.nextInt();
        System.out.println("Original array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("\nArray after inserting element at position " + position + ":");
        insertElement(array, position, element);
        scanner.close();
    }
}



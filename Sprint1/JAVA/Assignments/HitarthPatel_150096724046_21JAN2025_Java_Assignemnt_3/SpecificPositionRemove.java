import java.util.Scanner;

public class SpecificPositionRemove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print("Enter the index of the element to remove (0-" + (size - 1) + "): ");
        int removeIndex = scanner.nextInt();
        array = removeElement(array, removeIndex);
        System.out.println("Array after removing element at index " + removeIndex + ":");
        for (int i : array) {
            System.out.print(i + " ");
        }
        scanner.close();
    }

    public static int[] removeElement(int[] array, int index) {
        if (index < 0 || index >= array.length) {
            System.out.println("Invalid index. Returning original array.");
            return array;
        }
        int[] newArray = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        return newArray;
        
    }
}



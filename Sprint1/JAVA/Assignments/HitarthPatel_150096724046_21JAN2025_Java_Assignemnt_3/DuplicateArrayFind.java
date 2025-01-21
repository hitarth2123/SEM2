import java.util.Scanner;

public class DuplicateArrayFind {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        String[] array = new String[size];

        System.out.println("Enter the elements of the array: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.next();
        }

        System.out.println("Duplicate values in the array are: ");
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (array[i].equals(array[j])) {
                    System.out.print(array[i] + " ");
                }
            }
        }

        scanner.close();
    }
}


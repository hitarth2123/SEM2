import java.util.Scanner;

class LinearSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Enter the number to search: ");
        int number = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                System.out.println("Number found at index " + i);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Number not found in the array.");
        }

        scanner.close();
    }
}


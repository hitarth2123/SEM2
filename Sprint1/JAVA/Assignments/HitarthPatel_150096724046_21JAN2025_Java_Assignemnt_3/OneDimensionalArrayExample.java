
class OneDimensionalArrayExample {
    public static void main(String[] args) {
        int[] numbers = new int[5]; 

        int[] predefinedNumbers = {10, 20, 30, 40, 50};

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (i + 1) * 10; 
        }

        System.out.println("Numbers:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        System.out.println("\nPredefined Numbers:");
        for (int num : predefinedNumbers) {
            System.out.print(num + " ");
        }
    }
}

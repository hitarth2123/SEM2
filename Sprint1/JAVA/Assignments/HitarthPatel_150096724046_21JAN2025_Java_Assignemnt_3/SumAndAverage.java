import java.util.Scanner;

class SumAndAverage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] array = new double[5];
        double sum = 0;
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter element " + (i+1) + ": ");
            array[i] = scanner.nextDouble();
            sum += array[i];
        }
        double average = sum / 5;
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        
        scanner.close();
    }
}

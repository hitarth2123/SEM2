public class fibonaccinumber {
    public static void main(String[] args) {
        int a = 0, b = 1, count = 10;
        System.out.println("First " + count + " Fibonacci numbers are:");
        int i = 1;
        do {
            System.out.print(a + " ");
            int sum = a + b;
            a = b;
            b = sum;
            i++;
        } while (i <= count);
    }
}

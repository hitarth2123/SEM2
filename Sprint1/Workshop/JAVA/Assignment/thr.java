import java.util.List;
import java.util.stream.Collectors;

public class thr {
    public static int sumOfSquaresOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                     .filter(n -> n % 2 == 0)
                     .map(n -> n * n)
                     .reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int sum = sumOfSquaresOfEvenNumbers(numbers);
        System.out.println("Sum of squares of even numbers: " + sum);
    }
}

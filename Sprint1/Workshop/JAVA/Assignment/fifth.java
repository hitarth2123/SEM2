import java.util.List;
import java.util.stream.Collectors;

public class fifth {
    public static List<Integer> squaresOfOddNumbers(List<Integer> numbers) {
        return numbers.stream()
                     .filter(n -> n % 2 != 0)
                     .map(n -> n * n)
                     .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> squares = squaresOfOddNumbers(numbers);
        System.out.println("Squares of odd numbers: " + squares);
    }
}

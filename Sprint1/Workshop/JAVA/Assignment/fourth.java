import java.util.Arrays;
import java.util.Optional;

public class fourth {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 0, 2};
        Optional<Integer> secondLargest = Arrays.stream(array)
                .boxed()
                .sorted((a, b) -> b.compareTo(a))
                .distinct()
                .limit(2)
                .skip(1)
                .findFirst();

        if (secondLargest.isPresent()) {
            System.out.println("Second largest element is: " + secondLargest.get());
        } else {
            System.out.println("Array does not have a second largest element.");
        }
    }
}

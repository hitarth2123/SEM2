import java.util.*;

class LinkedListEx3 {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.add(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addFirst(4);
        deque.addLast(5);
        Iterator<Integer> descendingIterator = deque.descendingIterator();
        System.out.println("Descending Order: ");
        while (descendingIterator.hasNext()) {
            System.out.print(descendingIterator.next() + " ");
        }
        System.out.println("\nFirst Element: " + deque.getFirst());
        System.out.println("Last Element: " + deque.getLast());
        deque.offerFirst(6);
        deque.offerLast(7);
        System.out.println("After offerFirst and offerLast: " + deque);
        int firstElement = deque.removeFirst();
        int lastElement = deque.removeLast();
        System.out.println("First Element Removed: " + firstElement);
        System.out.println("Last Element Removed: " + lastElement);
        System.out.println("Remaining Elements: " + deque);
    }
}

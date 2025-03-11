package democodes;

import java.util.Comparator;
import java.util.Queue;
import java.util.PriorityQueue;

public class QueueEX {
    public static void main(String[] args) {
        Queue<Integer> q1 = new PriorityQueue<>(Comparator.reverseOrder());
        q1.add(7);
        q1.add(5);
        q1.add(9);
        System.out.println(q1.peek());

        System.out.println(q1.remove());
        
    }
}

import java.util.*;

public class TreeSetExamples {
    public static void main(String[] args) {
        // 1. add(E e)
        TreeSet<String> set1 = new TreeSet<>();
        set1.add("Apple");
        set1.add("Banana");
        System.out.println("add(E e): " + set1);

        // 2. addAll(Collection? extends E> c)
        TreeSet<String> set2 = new TreeSet<>();
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
        set2.addAll(list);
        System.out.println("addAll(Collection? extends E> c): " + set2);

        // 3. clear()
        TreeSet<String> set3 = new TreeSet<>();
        set3.add("Apple");
        set3.add("Banana");
        set3.clear();
        System.out.println("clear(): " + set3);

        // 4. contains(Object o)
        TreeSet<String> set4 = new TreeSet<>();
        set4.add("Apple");
        set4.add("Banana");
        System.out.println("contains(Object o): " + set4.contains("Apple"));

        // 5. isEmpty()
        TreeSet<String> set5 = new TreeSet<>();
        System.out.println("isEmpty(): " + set5.isEmpty());
        set5.add("Apple");
        System.out.println("isEmpty(): " + set5.isEmpty());

        // 6. iterator()
        TreeSet<String> set6 = new TreeSet<>();
        set6.add("Apple");
        set6.add("Banana");
        Iterator<String> iterator = set6.iterator();
        System.out.print("iterator(): ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();

        // 7. remove(Object o)
        TreeSet<String> set7 = new TreeSet<>();
        set7.add("Apple");
        set7.add("Banana");
        set7.remove("Apple");
        System.out.println("remove(Object o): " + set7);

        // 8. size()
        TreeSet<String> set8 = new TreeSet<>();
        set8.add("Apple");
        set8.add("Banana");
        System.out.println("size(): " + set8.size());

        // 9. toArray()
        TreeSet<String> set9 = new TreeSet<>();
        set9.add("Apple");
        set9.add("Banana");
        Object[] array = set9.toArray();
        System.out.println("toArray(): " + Arrays.toString(array));

        // 10. first()
        TreeSet<String> set10 = new TreeSet<>();
        set10.add("Apple");
        set10.add("Banana");
        System.out.println("first(): " + set10.first());

        // 11. last()
        TreeSet<String> set11 = new TreeSet<>();
        set11.add("Apple");
        set11.add("Banana");
        System.out.println("last(): " + set11.last());

        // 12. headSet(E toElement)
        TreeSet<String> set12 = new TreeSet<>();
        set12.add("Apple");
        set12.add("Banana");
        set12.add("Cherry");
        SortedSet<String> headSet = set12.headSet("Banana");
        System.out.println("headSet(E toElement): " + headSet);

        // 13. tailSet(E fromElement)
        TreeSet<String> set13 = new TreeSet<>();
        set13.add("Apple");
        set13.add("Banana");
        set13.add("Cherry");
        SortedSet<String> tailSet = set13.tailSet("Banana");
        System.out.println("tailSet(E fromElement): " + tailSet);

        // 14. containsAll(Collection?> c)
        TreeSet<String> set14 = new TreeSet<>();
        set14.add("Apple");
        set14.add("Banana");
        List<String> list2 = Arrays.asList("Apple", "Banana");
        System.out.println("containsAll(Collection?> c): " + set14.containsAll(list2));
    }
}
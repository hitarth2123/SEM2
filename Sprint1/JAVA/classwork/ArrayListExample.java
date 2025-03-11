import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("AA");
        list1.add("SS");
        list1.add("LL");
        list1.add("DD");
        System.out.println("List1: "+list1);
        list1.add(2,"PP");
        System.out.println("List2: "+list1);
        ArrayList<String> list2 = new ArrayList<String>(2);
        list2.add("CC");
        list2.add("GG");
        System.err.println("List2: "+list2);
        ArrayList<String> list3 = new ArrayList<String>(list2);
        System.out.println("List3: "+list3);
        list3.addAll(list1);
        System.out.println("List3: "+list3);

    }
}

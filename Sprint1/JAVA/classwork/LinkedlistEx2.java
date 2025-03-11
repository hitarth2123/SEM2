import java.util.*;

public class LinkedlistEx2{

public static void main(String args[]){

LinkedList<String> list = new LinkedList<String>();

list.add("AAA");

list.add("BBB");

list.add("CCC");

list.add("DDD");

System.out.println("list " + list);

list.addFirst("000");

list.addLast("ZZZ");

System.out.println("list " + list);

System.out.println("First " + list.getFirst());

System.out.println("Last " + list.getLast());

list.removeFirst();

System.out.println("After Rem First " + list);

list.removeLast();

System.out.println("Rem Last " + list);

LinkedList<String> list2 = new LinkedList<String>(list);

System.out.println("list2 " + list2);

}}

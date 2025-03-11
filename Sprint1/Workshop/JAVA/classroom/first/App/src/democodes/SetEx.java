package democodes;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetEx {
public static void main(String[] args) {
    Set<Integer> set = new HashSet<>();
    set.add(5);
    set.add(10);
    set.add(15);
    set.add(20);
    set.add(25);
    set.add(30);
    for(Integer i:set){
        System.out.println("value - "+i);
    }
    Set<Integer> set2 = new TreeSet<>();
    set2.add(5);
    set2.add(10);
    set2.add(15);
    set2.add(20);
    for(Integer i:set2){
        System.out.println("value - "+i);
    }
    
}
}

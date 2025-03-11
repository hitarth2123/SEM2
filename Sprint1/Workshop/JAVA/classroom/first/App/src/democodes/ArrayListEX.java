package democodes;

import java.util.ArrayList;

public class ArrayListEX {
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(10);
    list.add(20);
    list.add(30);
    list.add(40);
    list.add(50);
    System.out.println(list.get(0));


    for (Integer i:list){
        System.out.println("value - "+i);
    }
}

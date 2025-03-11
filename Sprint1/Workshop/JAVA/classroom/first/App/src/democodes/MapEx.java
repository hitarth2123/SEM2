package democodes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapEx {
    public static void main(String[] args) {
        
        Map<Integer, String> data = new HashMap<>();
        data.put(1, "One");
        data.put(2, "Two");
        data.put(3,"Three");
        data.put(4,"Four");
        System.out.println(data.keySet());
        System.out.println(data.values());
        System.out.println(data.entrySet());

        Iterator itr = data.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry entry = (Map.Entry)itr.next();
            System.out.println("Key - "+entry.getKey()+" Value - "+entry.getValue());
        }

        
    }
}

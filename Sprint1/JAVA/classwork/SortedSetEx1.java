import java.util.SortedSet; 
import java.util.TreeSet; 

public class SortedSetEx1 {

    public static void main(String[] args) { 
        SortedSet<String> set = new TreeSet<>(); 
        set.add("PP");
        set.add("DD");
        set.add("ZZ");
        set.add("AA");
        set.add("XX");
        set.add("CC");
        set.add("BB");
        
        System.out.println(set);
        System.out.println("The first element is given as: " + set.first());
        System.out.println("The last element is given as: " + set.last());
        System.out.println(set.headSet("DD"));
        System.out.println(set.tailSet("BB"));
        System.out.println(set.subSet("BB", "PP"));
        
        SortedSet<String> s = set.subSet("BB", "PP");
        s.add("EE");
        
        System.out.println(s); 
        System.out.println(set);
    }
}
    
  
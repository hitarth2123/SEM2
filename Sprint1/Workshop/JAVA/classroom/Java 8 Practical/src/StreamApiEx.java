import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;


class pract2{
   public static int getSquare(int n){
    return n*n;
   }
}
public class StreamApiEx {


    public static void main(String[] args) {
        ArrayList<Integer>nums=new ArrayList<>();
        nums.add(6);
        nums.add(9);
        nums.add(1);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(5);
        
        nums.stream().filter(n-> n%2!=0).forEach(System.out::println);

        nums.stream().map(n-> n*n).forEach(System.out::println);

        nums.stream().distinct().forEach(System.out::println);

        nums.stream().sorted().forEach(System.out::println);

        nums.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        List<Integer>evenNos=nums.stream().filter(n-> n%2==0).collect(Collectors.toList());

        nums.stream().forEach(pract2::getSquare);


    }
}
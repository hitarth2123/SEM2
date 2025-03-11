import java.util.*;
public class ArrayListEx4 {
    public static void main(String[] args) {
        ArrayList<String> list1= new ArrayList<String>();
                list1.add("AA");
                list1.add("BB");
                list1.add("CC");
                list1.add("DD");
                list1.add("AA");
                System.out.println("list1 "+list1);
                System.out.println("1. Iterate ArrayList using basic for loop*****");

                    for(int i=0; i<list1.size(); i++)
                        System.out.print(list1.get(i)+" ");
                System.out.println();
                System.out.println("2. Iterate ArrayList using for each loop*****");

                for(String str: list1)
                    System.out.print(str+" ");
                
                System.out.println();
                //Iterator Interface provides the facility of iterating the elements only in forward fashion.
                System.out.println("3. Iterating with iterator*****");
                Iterator <String> itr = list1.iterator();
                while(itr.hasNext()) {
                String str = itr.next();
                System.out.print(str+" ");}

                System.out.println();
                System.out.println("4. list1 after iterating using listIterator ");

                ListIterator<String> listItr = list1.listIterator();

                System.out.println("=============Forward=========");
                while(listItr.hasNext()) {
                System.out.print(listItr.next()+" ");}

                System.out.println();
                System.out.println("===========Backward=========");
                ListIterator<String> listItr1 = list1.listIterator(list1.size());
                while(listItr1.hasPrevious()) {
                System.out.print(listItr1.previous()+" ");
                }
                
                
            
        }
    }
import java.util.*;

public class ArrayListEx3{
   public static void main(String[] args) {
ArrayList<String> list1= new ArrayList<String>();
list1.add( "AA");
list1.add("BB");
list1.add( "CC");
list1.add( "DD");
list1.add( "AA");
System.out.println("list1 "+list1);
System.out.println("index of "+list1.indexOf( "AA")); System.out.println("last index of "+list1.lastIndexOf("AA"));
//****Contains*****
if(list1.contains( "CC"))
System.out.println( "CC is in the list");
else
System.out.println( "CC is not in the list");
//****GET elements from the list1
System.out.println("list1.get(3) "+list1.get(3));
//** SET elements
list1.set(2,"EE");
System.out.println("Updated list1 "+list1);
//**remove */
System.out.println("****REMOVING elements *****");
list1.remove(2);
System.out.println("list1 after removing element at index 2 "+list1);
//**remove */
list1.remove("DD");
System.out.println("list1 after removing element DD "+list1);
//****CLEAR all elements
list1.clear();
//isEmpty()
System.out.println("****isEmpty()****");
 if(list1.isEmpty()){
    System.out.println( "List1 is empty");
 }
else{System.out.println("List1 is not empty");
}
   }
   
}
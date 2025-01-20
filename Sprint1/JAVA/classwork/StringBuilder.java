class Stringbuilder {
    public static void main(String[] args) {

        StringBuilder sb1= new StringBuilder("Hello World");
        System.out.println(sb1);
        StringBuilder reverseSb=sb1.reverse();
        System.out.println("Reverse String = "+ reverseSb);
        System.out.println("Modified Stringbuider = "+sb1);

        StringBuilder sb2= new StringBuilder();
        System.out.println("Capacity of StringBuilder = "+sb2.capacity());
    
    //charAt(),indexOf(),length(),substring(),same as String
    // int lastIndexOf(String str)
    // Returns the index within this string of the rightmost occurence os the specified substring                  
    // int lastIndexOf(String str, int fromIndex)
    // Returns the index within this string if the last occurrence of the specified substring
    // int length()
    // String substring(int start)
    /*
     StringBuilder append(boolean b): Appends the tring representation of the boolean argument
     StringBuilder append(char c)
     StringBuilder append(char[] str)
     StringBuilder append(char[] str, int offset, int len)
     StringBuilder append(double d)
     StringBuilder append(float f)
     StringBuilder append(int i)
     StringBuilder append(long lng)
     StringBuilder append(String str)
     */

     sb2.append("Hello");
     sb2.append(" ");
     sb2.append("world");
     System.out.println(sb2.toString());
     System.out.println(sb2);
     StringBuilder sb22= new StringBuilder();

     sb22.append("Hello").append(" ").append("world");
     System.out.println(sb22);
     sb2.insert(6,"beautiful");
     System.out.println(sb2.toString());

     StringBuilder sb3 =new StringBuilder("Hello");
     sb3.replace(1,3,"Java");
     System.out.println("After Replace() String = "+sb3.toString());

     StringBuilder sb4= new StringBuilder("Hello");
     sb4.delete(1,3);
     System.out.println(sb4);
     
     StringBuilder sb5 =new StringBuilder();
     System.out.println(sb5.capacity());
     sb5.append("Hello");
     System.out.println(sb5.capacity());

     sb5.append("Java is my favourite Language");
     System.out.println(sb5.capacity());

     sb5.ensureCapacity(10);
     System.out.println(sb5.capacity());
     sb5.ensureCapacity(50);
     System.out.println(sb5.capacity());

     StringBuilder sb6= new StringBuilder("Hello");
     System.out.println(sb6.charAt(1));
     System.out.println(sb6.length());
     System.out.println(sb6.substring(1, 5));
     System.out.println(sb6.substring(1));
    }
}

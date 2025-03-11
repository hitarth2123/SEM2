package democodes;

public class StringEx {
    public static void main(String[] args) {
        String s1= "Hello";
        System.out.println(s1);

        StringBuilder s2 = new StringBuilder("Hello");
        s2.append("World");
        System.out.println(s2);

        s2.append("java").deleteCharAt(0).append("programming");     
        System.out.println(s1);

    }


}

import java.util.Arrays;

public class Stringclass {
    public static void main(String[] args) {
        String str = "Hello, World!";
        System.out.println("Length of the string: " + str.length());
        System.out.println("Character at index 4: " + str.charAt(4));
        System.out.println("Index of 'o': " + str.indexOf('o'));
        System.out.println("Index of 'o' after index 5: " + str.indexOf('o', 5));
        System.out.println("Index of 'World': " + str.indexOf("World"));
        System.out.println("Index of 'World' after index 5: " + str.indexOf("World", 5));
        System.out.println("Last index of 'o': " + str.lastIndexOf('o'));
        System.out.println("Substring from index 7: " + str.substring(7));
        System.out.println("Substring from index 7 to 12: " + str.substring(7, 12));
        System.out.println("Contains 'World': " + str.contains("World"));
        System.out.println("Concatenation with '!' : " + str.concat("!"));
        System.out.println("Equals 'Hello, World!': " + str.equals("Hello, World!"));
        System.out.println("Equals ignore case 'hello, world!': " + str.equalsIgnoreCase("hello, world!"));
        System.out.println("Is empty: " + str.isEmpty());
        System.out.println("To lower case: " + str.toLowerCase());
        System.out.println("To upper case: " + str.toUpperCase());
        System.out.println("Compare to 'Hello, World!': " + str.compareTo("Hello, World!"));
        System.out.println("Compare to ignore case 'hello, world!': " + str.compareToIgnoreCase("hello, world!"));
        System.out.println("Trim: " + str.trim());
        System.out.println("Replace 'o' with '0': " + str.replace('o', '0'));
        System.out.println("To char array: " + Arrays.toString(str.toCharArray()));
        System.out.println("Starts with 'Hello': " + str.startsWith("Hello"));
        System.out.println("Ends with 'World!': " + str.endsWith("World!"));
        System.out.println("Join with ', ': " + String.join(", ", "Hello", "World!"));
    }
}


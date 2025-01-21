public class ReplaceSubstring {
    public static void main(String[] args) {
        String str = "Hello, World!";
        String oldSubStr = "World";
        String newSubStr = "Universe";

        String newStr = str.replace(oldSubStr, newSubStr);

        System.out.println("Original String: " + str);
        System.out.println("New String: " + newStr);
    }
}

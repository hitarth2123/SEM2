public class NewString {
    public static void main(String[] args) {
        String str = "hello";
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            newStr += str.charAt(i);
            newStr += str.charAt(i);
        }
        System.out.println(newStr);
    }
}

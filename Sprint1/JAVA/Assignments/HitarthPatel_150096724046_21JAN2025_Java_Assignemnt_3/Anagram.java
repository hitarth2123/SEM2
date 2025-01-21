public class Anagram {
    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        char[] charArray1 = str1.toLowerCase().toCharArray();
        char[] charArray2 = str2.toLowerCase().toCharArray();

        java.util.Arrays.sort(charArray1);
        java.util.Arrays.sort(charArray2);

        return java.util.Arrays.equals(charArray1, charArray2);
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("listen", "silent"));  
        System.out.println(areAnagrams("hello", "world"));  
    }
}


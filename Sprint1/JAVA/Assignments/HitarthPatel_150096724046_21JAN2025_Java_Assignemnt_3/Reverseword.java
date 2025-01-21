class Reverseword {
    public static void main(String[] args) {
        String str = "Hello World";
        String[] words = str.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reversedWord = new StringBuilder(word).reverse().toString();
            System.out.print(reversedWord + " ");
        }
    }
}


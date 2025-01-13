 class ReverseAlphabet {
    public static void main(String[] args) {
        for(char c = 'z'; c >= 'a'; c--) {
            String upperCaseCh = String.valueOf(c).toUpperCase();
            System.out.print(upperCaseCh + " ");
        }
    }
}

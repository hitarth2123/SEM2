class  StringEx {
    public static void main(String[] args) {
        String s1 = "Hello ";
        System.out.println(s1);

        String s2=new String("World");
        System.out.println(s2);

        String s21=new String(s2);
        System.out.println(s21);

        char[] ch={'j','a','v','a',' ','w','o','r','l','d'};
        String sch1= new String(ch);
        System.err.println(sch1);

        String sch2=new  String(ch,2,5);
        System.out.println(sch2);
    }
}
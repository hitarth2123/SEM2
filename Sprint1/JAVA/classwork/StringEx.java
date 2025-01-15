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

        //String Pool
        String s5="abc";
        String s6="abc";
        String s66= new String("abc");
        if(s5==s6){
            System.out.println("s5 equal to s6");
        }
        else{
            System.out.println("s5 not equal to s6");
        }
        if(s6==s66){
            System.out.println("s6 equal to s66");
        }
        else{
            System.out.println("s6 not equal to s66");
        }
        
        //concatenation
        String s3=s1+s2;
        System.out.println(s3);
        String s4=s3+4+4;
        System.out.println(s4+23);
        String s41=s4.concat("55");
        System.out.println(s41);
        s41.concat("66");
        System.out.println(s41);

       
        
    }
}
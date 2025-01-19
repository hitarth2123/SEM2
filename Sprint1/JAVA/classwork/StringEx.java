import java.util.Arrays;

class  StringEx {
    public static void main(String[] args) {
        //constrcutor
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

        //Convertign different to string
        int a= 1234;
        double b=1234.56;
        boolean c=false;
        String str1=Integer.toString(a);
        String str2=String.valueOf(b);
        String str3=""+c;
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        
       //length()
        String sm1="Hello";
        System.out.println("Length of the String "+sm1.length());

        //isEmpty()
        System.out.println("STring hello is empty or not "+sm1.isEmpty());
        System.out.println("String is empty or not "+"".isEmpty());

        //charAt()
        System.out.println("charAt(index:1)"+sm1.charAt(1));

        //indexOf()

        //public int indexOf(String str)
        //public int indexOf(String str,int fromIndex)
        //public int indexOf(char ch)
        //public int indexOf(char ch,int fromIndex) 
        String sm2="this is an index";
        int index1=sm2.indexOf("is");
        System.out.println("indexOf(char:e)"+index1);

        int index2=sm2.indexOf('s',4);
        System.out.println("indexOf(String:is,fromIndex:5)"+index2);

        int index3=sm2.indexOf('s');
        System.out.println("indexOf(char:i)"+index3);

        int index4=sm2.indexOf(97,5);
        System.out.println("indexOf(97 s)"+index4);
        
        int index5=sm2.indexOf("iss",5);
        System.out.println("indexOf(String:iss,fromIndex:5)"+index5);

        //public int lastIndexOf(String str)
        //public int lastIndexOf(String str,int fromIndex)

        int index6=sm2.lastIndexOf('e');
        System.out.println("lastIndexOf(char:e)"+index6);

        int index7=sm2.lastIndexOf('i',10);
        System.out.println("lastIndexOf(String:i,fromIndex:10)"+index7);

        //public String substring(int begIndex);
        String ss1="Substring Example";
        System.out.println("ss2 : "+ss1.substring(2));

        //public String substring(int begIndex, int endIndex)
        System.out.println("ss1 1,5 : "+ss1.substring(1,5));
        System.out.println("ss1 1,1 :"+ss1.substring(1,1));

        String sm3="Hello";
        
        //public void getChars(int srcBegin, int srcEnd,char[] dst ,int dstBegin)
        //Copies characters from this string into the desitnation charcter array.
        char[]arr=new char[10];
        Arrays.fill(arr,'.');
        sm3.getChars(0,3,arr,1);
        System.out.println(Arrays.toString(arr));

        //public boolean equals(Object anObject);
        String e1="java";
        String e2="java";
        String e3="JAVA";
        String e4="python";
        String e5=new String("java");
        System.out.println(e1.equals(e2));
        System.out.println(e1.equals(e3));
        System.out.println(e1.equals(e4));
        System.out.println("e1 equals e5"+e1.equals(e5));

        //public boolean equalsIgnoreCase(String anotherString)
        if(e1.equalsIgnoreCase(e3)){
            System.out.println("both strings are equals");
        }
        else{
            System.out.println("both strings are unequals");
        }
        
        // public int compareTo(String anotherString);
        String c1="hello";
        String c2="hello";
        System.out.println(c1.compareTo(c2));

        String c3="ieklo";
        System.out.println(c1.compareTo(c3));

        String c4="heklo";
        System.out.println(c1.compareTo(c4));

        String c5="flagship";
        System.out.println(c1.compareTo(c5));
        String c6="Hello";
        System.out.println(c1.compareTo(c6));

        //public int compareToIgnoreCasting(String str);
        System.out.println(c1.compareToIgnoreCase(c6));

        //boolean startswith(String prefix)
        //public boolean startswith(String prefix, int toffset)


        String sw1= "hello world";
        System.out.println(sw1.startsWith("ll"));
        System.out.println(sw1.startsWith("ll",2));
        System.out.println(sw1.endsWith("ld"));

        //public booelan contains(charSequence s)
        String co1="Hello, World";
        System.out.println(co1.contains("hello"));
        System.out.println(co1.contains(("ello")));

        //public static String join(CharSequence delimiter ,CharSequence... elements)
        String msg=String.join("-","Java","is","cool");
        System.out.println(msg);

        String msg1=String.join("*", "Java",null,"cool");
        System.out.println(msg1);

        String msg2=String.join("#",null,null,null);
        System.out.println(msg2);

        //compile time error:jooin ambiguous for String type
        //String msg2=String.join('#',null);
        //System.out.println(msg2);

        //public String toLowerCase()
        System.out.println(msg.toLowerCase());

        System.out.println(msg.toUpperCase());

        //isBlank() Returns truw if the string is empty or contains only while spaces
        System.out.println("".isEmpty());
        System.out.println("".length());
        System.out.println(" ".isEmpty());
        System.out.println(" ".length());
        System.out.println("\t\n".isEmpty());
        System.out.println("\t\n".length());
        System.out.println(" ".isBlank());
        System.out.println("\ta\n".isEmpty());
        System.out.println("\ta\n".isBlank());

        //public String replacer(char oldChar,char newChar)
        String str="Hello World";
        String replaced= str.replace("o","a");
        System.out.println("replace"+replaced);

        String sca="hello";
        char[] ch1=sca.toCharArray();
        System.out.println(Arrays.toString(ch1));

        //he solit() method divides the string at the specifed regex and returns an a
        String text="Java is fun programming language";
        //split string from space
        String[] result =text.split(" ");
        System.out.println(Arrays.toString(result));
        String s11=text.replace("[a-zA-Z0-9]", "");
        System.out.println(s11);

        //public String trim()
        //public String strip()
        //public String stripLeading()
        //public String strpTrailing()
        //public boolean isBlank()
        //static String valueOf(double num)
        //static String valueOf(long num)
        //static String valueOf(Object ob)
        //static String valueOf(char chars[ ])

    }
}

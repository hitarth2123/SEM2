 class StringBuilder {
    public static void main(String[] args) {
        StringBuilder sb1= new StringBuilder(str:"Hello World");
        System.out.println(sb1);
        StringBuilder reverseSb=sb1.reverse();
        System.out.println("Reverse String = "+ reverseSb);
        System.out.println("Modified Stringbuider = "+sb1);

        StringBuilder sb2= new StringBuilder();
        System.out.println("Capacity of StringBuilder = "+sb2.capacity());
    
    //charAt(),indexOf(),length(),substring(),same as String
    // int lastIndexOf(String str)
                        

    }
}


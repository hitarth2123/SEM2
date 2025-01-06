 class BasicMath {
    public static void main(String[]args){
        int a=1+1;
        int b=a*3;
        int c=b/4;
        int d=c-a;
        int e=-d;
        System.out.printf("a=%d,b=%d,c=%d,d=%d,e=%d",a,b,c,d,e);
        System.out.println("\n Floating Point Arithmetic");
        double da=1+1;
        double db=da*3;
        double dc=db/4;
        double dd=dc-a;
        double de=-dd;
        System.out.printf("a=%f,b=%f,c=%f,d=%f,e=%f",da,db,dc,dd,de);
        int x=42;
        double y=42.45;
        System.out.println("x mod 10 ="+x%10);
        System.out.println("y mod 10 ="+y%10);

    }
    
}

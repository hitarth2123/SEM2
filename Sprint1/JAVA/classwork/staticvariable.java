class StaticDemo{
   static int a =12;
   static int b=23;
   static void callme(){
      System.out.println("a = "+a);
   }
}

class staticvariable {
   public static void main(String[] args) {
      StaticDemo.callme();
      System.out.println("b = "+StaticDemo.b);

   } 
}

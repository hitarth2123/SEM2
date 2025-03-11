package democodes;
public class StaticEx {

    static     //static class
    {
        System.out.println("inside the static block");

    }
    //nested classes can only be static
    static class Data{
        int d;
    }
    public static void main(String args[])
    {
        System.out.println("Inside main");
    }

}
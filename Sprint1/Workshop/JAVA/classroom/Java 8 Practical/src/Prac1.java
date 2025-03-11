@FunctionalInterface
interface ArithmeticOperations {
    public void addition(int num1, int num2);

}
    //Lamda expression are used to give implementation of abstract of functional interface

 public class Prac1
{
    
    public static void main(String[] args)
    {
        ArithmeticOperations a1 = (n1,n2) -> {
            int a =n1+n2;
            System.out.println("addition is "+a);
        };
        a1.addition(1, 2);
    } 
}
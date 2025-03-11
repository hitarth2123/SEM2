@FunctionalInterface
interface InterfaceEx {
    public void execute();
    // functional interface contains only 1 abstract method

    // use @functionalinterface annotation to declare interface at functional and restrict declaration of only 1 abstract method

}
// class Demo implements InterfaceEx
// {
//     public void execute()
//     {
//         System.out.println("inside execute");
//     }

// }
public class Demo2{
    public static void main(String[] args) {
        InterfaceEx e1 = () -> {
            System.out.println("inside execute");
        };
        e1.execute();

    }
}
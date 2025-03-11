interface Bank{
    void deposit();
    void withdraw();
    void loan();
    void amount();
}
abstract class Dev1 implements Bank{
    public void deposit(){
        System.out.println("Deposit");
    }
}
abstract class Dev2 extends Dev1{
    public void withdraw(){
        System.out.println("Withdraw");
    }
}
class Dev3 extends Dev2{
    public void loan(){
    }
    public void amount(){
    }
}
class Interface1 {
    public static void main(String[] args) {
        Dev3 d = new Dev3();
        d.deposit();
        d.withdraw();
        d.loan();
        d.amount();

    }
}

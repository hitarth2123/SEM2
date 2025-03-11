package democodes;
public interface Bank {
    public void calculateInterest();

    public void getloan();

    public void createAccount();

}
class SBI implements Bank{
    @Override
    public void calculateInterest()
    {
        System.out.println("Interest rate is 35");
    }

    @Override
    public void getloan()
    {
        System.out.println("The loan amout of SBI");
    }
   
    @Override
    public void createAccount()
    {
        System.out.println("use The online app");
    }

}
class ICIC implements Bank{
    @Override
    public void calculateInterest()
    {
        System.out.println("Interest rate is 30");
    }

    @Override
    public void getloan()
    {
        System.out.println("The loan amout of ICIC");
    }
   
    @Override
    public void createAccount()
    {
        System.out.println("use The online app");
    }

}

class InterfaceEX
{
    public static void main(String args[])
    {
        SBI s1= new SBI();
        s1.calculateInterest();
        s1.createAccount();

        ICIC c1= new ICIC();
        c1.calculateInterest();
        c1.createAccount();
    }
}
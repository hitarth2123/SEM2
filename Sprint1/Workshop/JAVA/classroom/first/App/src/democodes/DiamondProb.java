package democodes;

class DiamondProb {
    public void msg()
    {
        System.out.println("Hello");
    }
}

class A extends DiamondProb
{
    public void msg()
    {
        System.out.println("Hello from A");
    }
}

class B extends DiamondProb
{
    public void msg()
    {
        System.out.println("Hello from B");
    }
}

class C extends B
{
    public void msg()
    {
        System.out.println("Hello from C");
    }
}

class Main
{
    public static void main(String[] args)
    {
        C obj = new C();
        obj.msg();
    }
}
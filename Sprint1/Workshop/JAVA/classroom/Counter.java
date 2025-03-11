public class Counter 
{
    int count=1;

    public  void increment()
    {
        for(int i=0;i<=1000;i++)
        {
            count++;
        }
    }

    public void display()
    {
        System.out.println("Count value is "+count);
    }
        
}
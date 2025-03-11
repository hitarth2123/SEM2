public class ThreadImpl extends Thread 
{


    Counter c1 = new Counter();
    public ThreadImpl(Counter c1)
    {
        this.c1=c1;
    }

    
    @Override
    public void run()
    {
        c1.increment();

    }


}
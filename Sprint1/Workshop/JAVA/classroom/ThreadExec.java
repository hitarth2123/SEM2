public class ThreadExec 
{
    public static void main(String[] args) {

        Counter c = new Counter();
        ThreadImpl t1 = new ThreadImpl(c);
        ThreadImpl t2 = new ThreadImpl(c);
        t1.start();
        t2.start();

        c.display();

    }

}
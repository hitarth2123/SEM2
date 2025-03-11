package democodes;

class ThreadEx1 extends Thread{
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Sqaures of "+i+" is "+i*i);
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {
        ThreadEx1 t1 = new ThreadEx1();
        ThreadEx1 t2 = new ThreadEx1();
        ThreadEx1 t3 = new ThreadEx1();

        
    }
}

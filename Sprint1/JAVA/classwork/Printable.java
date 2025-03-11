public interface Printable{
    void print();
}
interface Showable{
    void show();
}


class InterfaceMulitple implements Printable,Showable{
    public void print(){
        System.out.println("Hello");
    }
    public void show(){
        System.out.println("Welcome");
    }

    public static void main(String[] args) {
        inter1 obj = new inter1();
        obj.print();
        obj.show();

    }
    
}


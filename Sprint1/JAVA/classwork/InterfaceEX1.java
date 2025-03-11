interface Printable{
    void print();
}
class Interface1 implements Printable{
    public void print(){
        System.out.println("Hello");
    }
  
    public static void main(String[] args) {
        inter1 obj = new inter1();
        obj.print();

    }
    
}

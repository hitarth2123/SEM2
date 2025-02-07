class Animal{
    String name ;
    public void eat(){
        System.out.println("I can eat");
    }
}
class Dog extends Animal{
    public void bark(){
        System.out.println(name +"barks");
    }
}

class SingleInhertiance {
    public static void main(String[] args) {
        Animal labrador= new Dog();
        labrador.name="Rocky";
        labrador.eat();
    }
}

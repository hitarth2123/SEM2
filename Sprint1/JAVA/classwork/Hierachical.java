class Animal {
    String name ;
    public void eat(){
        System.out.println(name +"eat");
    }
    Animal(){}
    Animal(String n){name =n;}
    
}

class Dog extends Animal{
    public void bark(){
        System.out.println(name+"barks");
    }
    Dog(){}
    Dog(String n){super(n);}
}

class Cat extends Animal{
    public void meow(){
        System.out.println(name+"meow");
    }
}

class Hierachical{
    public static void main(String[] args) {
        Animal a=new Animal();
        a.name ="rocky";
        a. eat();

        Dog d= new Dog("Tuffy");
        d.eat();
        d.bark();

        Cat c =new Cat();
        c.eat();
        c.meow();
    }
}
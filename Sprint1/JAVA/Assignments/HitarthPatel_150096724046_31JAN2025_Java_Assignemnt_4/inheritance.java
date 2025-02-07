class inheritance{
    
    // Single Inheritance
    public class Animal {
        public void eat() {
            System.out.println("Eating...");
        }
    }
    
    public class Dog extends Animal {
        public void bark() {
            System.out.println("Barking...");
        }
    }
    
    // Multilevel Inheritance
    public class Mammal extends Animal {
        public void walk() {
            System.out.println("Walking...");
        }
    }
    
    public class Cat extends Mammal {
        public void meow() {
            System.out.println("Meowing...");
            
        }
    }
    
    // Hierarchical Inheritance
    public class Vehicle {
        public void move() {
            System.out.println("Moving...");
        }
    }
    
    public class Car extends Vehicle {
        public void accelerate() {
            System.out.println("Accelerating...");
        }
    }
    
    public class Truck extends Vehicle {
        public void load() {
            System.out.println("Loading...");
        }
    }
    
    // Hybrid Inheritance
    public class ElectricCar extends Car {
        public void charge() {
            System.out.println("Charging...");
        }
    }
    
    }
    
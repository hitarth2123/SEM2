import java.util.Scanner;

public class Animal {
    private boolean vegetarian;
    private String food;
    private int numOfLegs;

    public Animal() {
        this.vegetarian = false;
        this.food = "Unknown";
        this.numOfLegs = 0;
    }

    public Animal(boolean vegetarian, String food, int numOfLegs) {
        this.vegetarian = vegetarian;
        this.food = food;
        this.numOfLegs = numOfLegs;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public int getNumOfLegs() {
        return numOfLegs;
    }

    public void setNumOfLegs(int numOfLegs) {
        this.numOfLegs = numOfLegs;
    }

    public String toString() {
        return "Animal{" +
                "vegetarian=" + vegetarian +
                ", food='" + food + '\'' +
                ", numOfLegs=" + numOfLegs +
                '}';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Is the animal vegetarian? (true/false): ");
        boolean vegetarian = scanner.nextBoolean();

        System.out.println("What does the animal eat? ");
        String food = scanner.next();

        System.out.println("How many legs does the animal have? ");
        int numOfLegs = scanner.nextInt();

        Animal animal = new Animal(vegetarian, food, numOfLegs);
        System.out.println(animal.toString());

        scanner.close();
    }
}

class Cat extends Animal {
    private String color;

    public Cat() {
        super();
        this.color = "Unknown";
    }

    public Cat(boolean vegetarian, String food, int numOfLegs, String color) {
        super(vegetarian, food, numOfLegs);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Cat{" +
                "color='" + color + '\'' +
                ", " + super.toString() +
                '}';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Is the cat vegetarian? (true/false): ");
        boolean vegetarian = scanner.nextBoolean();

        System.out.println("What does the cat eat? ");
        String food = scanner.next();

        System.out.println("How many legs does the cat have? ");
        int numOfLegs = scanner.nextInt();

        System.out.println("What color is the cat? ");
        String color = scanner.next();

        Cat cat = new Cat(vegetarian, food, numOfLegs, color);
        System.out.println(cat.toString());

        scanner.close();
    }
}

class Cow extends Animal {
    private String breed;

    public Cow() {
        super();
        this.breed = "Unknown";
    }

    public Cow(boolean vegetarian, String food, int numOfLegs, String breed) {
        super(vegetarian, food, numOfLegs);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String toString() {
        return "Cow{" +
                "breed='" + breed + '\'' +
                ", " + super.toString() +
                '}';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Is the cow vegetarian? (true/false): ");
        boolean vegetarian = scanner.nextBoolean();

        System.out.println("What does the cow eat? ");
        String food = scanner.next();

        System.out.println("How many legs does the cow have? ");
        int numOfLegs = scanner.nextInt();

        System.out.println("What breed is the cow? ");
        String breed = scanner.next();

        Cow cow = new Cow(vegetarian, food, numOfLegs, breed);
        System.out.println(cow.toString());

        scanner.close();
    }
}
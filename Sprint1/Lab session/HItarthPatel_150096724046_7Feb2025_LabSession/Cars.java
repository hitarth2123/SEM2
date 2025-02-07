/*
 Write a Java program to create a vehicle class hierarchy. The base class should be  Vehicle, with subclasses Truck, Car and Motorcycle. Each subclass should have  properties such as make, model, year, and fuel type. Implement methods for  calculating fuel efficiency, distance traveled, and maximum speed.
 */

import java.util.Scanner;

class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected String fuelType;

    public Vehicle(String make, String model, int year, String fuelType) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
    }

    public double calculateFuelEfficiency() {
        return 0; 
    }

    public double calculateDistanceTraveled() {
        return 0; 
    }

    public double calculateMaximumSpeed() {
        return 0; 
    }
}

class Truck extends Vehicle {
    private double fuelCapacity;
    private double fuelEfficiency;

    public Truck(String make, String model, int year, String fuelType, double fuelCapacity, double fuelEfficiency) {
        super(make, model, year, fuelType);
        this.fuelCapacity = fuelCapacity;
        this.fuelEfficiency = fuelEfficiency;
    }

    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }

    public double calculateDistanceTraveled() {
        return fuelCapacity * fuelEfficiency;
    }

    public double calculateMaximumSpeed() {
        return 100; 
    }
}

class Car extends Vehicle {
    private double fuelCapacity;
    private double fuelEfficiency;

    public Car(String make, String model, int year, String fuelType, double fuelCapacity, double fuelEfficiency) {
        super(make, model, year, fuelType);
        this.fuelCapacity = fuelCapacity;
        this.fuelEfficiency = fuelEfficiency;
    }

    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }

    public double calculateDistanceTraveled() {
        return fuelCapacity * fuelEfficiency;
    }

    public double calculateMaximumSpeed() {
        return 120; 
    }
}

class Motorcycle extends Vehicle {
    private double fuelCapacity;
    private double fuelEfficiency;

    public Motorcycle(String make, String model, int year, String fuelType, double fuelCapacity, double fuelEfficiency) {
        super(make, model, year, fuelType);
        this.fuelCapacity = fuelCapacity;
        this.fuelEfficiency = fuelEfficiency;
    }

    public double calculateFuelEfficiency() {
        return fuelEfficiency;
    }

    public double calculateDistanceTraveled() {
        return fuelCapacity * fuelEfficiency;
    }

    public double calculateMaximumSpeed() {
        return 150; 
    }
}

public class Cars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter vehicle type (Truck, Car, Motorcycle): ");
        String vehicleType = scanner.nextLine();

        System.out.println("Enter vehicle make: ");
        String make = scanner.nextLine();

        System.out.println("Enter vehicle model: ");
        String model = scanner.nextLine();

        System.out.println("Enter vehicle year: ");
        int year = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("Enter vehicle fuel type: ");
        String fuelType = scanner.nextLine();

        System.out.println("Enter vehicle fuel capacity: ");
        double fuelCapacity = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("Enter vehicle fuel efficiency: ");
        double fuelEfficiency = scanner.nextDouble();
        scanner.nextLine(); 

        Vehicle vehicle = null;
        if (vehicleType.equalsIgnoreCase("Truck")) {
            vehicle = new Truck(make, model, year, fuelType, fuelCapacity, fuelEfficiency);
        } else if (vehicleType.equalsIgnoreCase("Car")) {
            vehicle = new Car(make, model, year, fuelType, fuelCapacity, fuelEfficiency);
        } else if (vehicleType.equalsIgnoreCase("Motorcycle")) {
            vehicle = new Motorcycle(make, model, year, fuelType, fuelCapacity, fuelEfficiency);
        }

        if (vehicle != null) {
            System.out.println("Vehicle Details:");
            System.out.println("Make: " + vehicle.make);
            System.out.println("Model: " + vehicle.model);
            System.out.println("Year: " + vehicle.year);
            System.out.println("Fuel Type: " + vehicle.fuelType);
            System.out.println("Fuel Efficiency: " + vehicle.calculateFuelEfficiency());
            System.out.println("Distance Traveled: " + vehicle.calculateDistanceTraveled());
            System.out.println("Maximum Speed: " + vehicle.calculateMaximumSpeed());
        } else {
            System.out.println("Invalid vehicle type.");
        }

        scanner.close(); 
    }
}

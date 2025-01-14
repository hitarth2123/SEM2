class Car:
    def __init__(self, make, model, year):
        self.make = make
        self.model = model
        self.year = year

    def describe_car(self):
        print(f"This car is a {self.year} {self.make} {self.model}.")

class ElectricCar(Car):
    def __init__(self, make, model, year, battery_size):
        super().__init__(make, model, year)
        self.battery_size = battery_size

    def describe_battery(self):
        print(f"This car has a {self.battery_size} kWh battery.")

make = input("Enter the make of the car: ")
model = input("Enter the model of the car: ")
year = input("Enter the year of the car: ")
battery_size = input("Enter the battery size of the car: ")

car = ElectricCar(make, model, year, battery_size)
car.describe_car()
car.describe_battery()




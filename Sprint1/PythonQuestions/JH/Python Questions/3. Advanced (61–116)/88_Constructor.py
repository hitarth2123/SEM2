class Car:
    def __init__(self, make, model, year):
        self.make = make
        self.model = model
        self.year = year

    def display_details(self):
        print(f"Car: {self.year} {self.make} {self.model}")

car = Car("Toyota", "Corolla", 2020)
car.display_details()

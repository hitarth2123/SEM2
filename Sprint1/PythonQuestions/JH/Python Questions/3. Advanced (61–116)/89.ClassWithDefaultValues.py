class Car:
    def __init__(self, make="Unknown", model="Unknown", year=2000):
        self.make = make
        self.model = model
        self.year = year

    def display_details(self):
        print(f"Car: {self.year} {self.make} {self.model}")

car1 = Car()
car2 = Car("Honda", "Civic", 2021)

car1.display_details()
car2.display_details()

class Circle:
    def __init__(self, radius):
        self.radius = radius

    def area(self):
        return 3.14 * self.radius ** 2

    def circumference(self):
        return 2 * 3.14 * self.radius

radius = float(input("Enter the radius of the circle: "))
circle = Circle(radius)
print("Area of the circle: ", circle.area())
print("Circumference of the circle: ", circle.circumference())



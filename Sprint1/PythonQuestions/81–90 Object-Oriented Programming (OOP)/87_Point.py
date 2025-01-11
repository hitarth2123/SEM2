class Point:
    def __init__(self, x=0, y=0):
        self.x = x
        self.y = y

    def set_coordinates(self, x, y):
        self.x = x
        self.y = y

    def calculate_distance(self, other_point):
        return ((self.x - other_point.x) ** 2 + (self.y - other_point.y) ** 2) ** 0.5

    @classmethod
    def get_user_input(cls):
        x = float(input("Enter x coordinate: "))
        y = float(input("Enter y coordinate: "))
        return cls(x, y)

    def __str__(self):
        return f"Point({self.x}, {self.y})"

    def print_point(self):
        print(f"Point coordinates: ({self.x}, {self.y})")

point1 = Point.get_user_input()
point2 = Point.get_user_input()
point1.print_point()
point2.print_point()
print(f"Distance between points: {point1.calculate_distance(point2)}")

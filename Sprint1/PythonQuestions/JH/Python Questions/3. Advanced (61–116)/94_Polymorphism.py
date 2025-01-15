class Shape:
    def draw(self):
        print("Drawing a shape.")

class Circle(Shape):
    def draw(self):
        print("Drawing a circle.")

class Triangle(Shape):
    def draw(self):
        print("Drawing a triangle.")

shapes = [Circle(), Triangle(), Shape()]
for shape in shapes:
    shape.draw()

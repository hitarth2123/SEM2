class DemoMethods:
    def __init__(self, name):
        self.name = name

    def instance_method(self):
        return f"Instance method called by {self.name}"

    @classmethod
    def class_method(cls):
        return "Class method called"

    @staticmethod
    def static_method():
        return "Static method called"

name = input("Enter your name: ")

demo = DemoMethods(name)

print("Output:")
print("--------")
print("Instance Method:")
print(demo.instance_method())
print("\nClass Method:")
print(DemoMethods.class_method())
print("\nStatic Method:")
print(DemoMethods.static_method())




class Temperature:
    def __init__(self, celsius=0):
        self.__celsius = celsius

    @property
    def celsius(self):
        return self.__celsius

    @celsius.setter
    def celsius(self, value):
        if value < -273.15:
            print("Temperature cannot be below absolute zero!")
        else:
            self.__celsius = value

temp = Temperature()
temp.celsius = 25
print(f"Temperature: {temp.celsius}°C")
temp.celsius = -300  

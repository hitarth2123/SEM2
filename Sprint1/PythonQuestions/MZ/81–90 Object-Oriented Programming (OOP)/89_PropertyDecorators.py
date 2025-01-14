class Product:
    def __init__(self, name, price=9.99):
        self._name = name
        self._price = price

    @property
    def name(self):
        return self._name

    @property
    def price(self):
        return self._price

    @price.setter
    def price(self, value):
        if value < 9.99:
            print("Price cannot be less than $9.99")
            self._price = 9.99
        else:
            self._price = value

    def __str__(self):
        return f"{self.name}: ${self.price:.2f}"

def get_user_input():
    name = input("Enter the product name: ")
    price = float(input("Enter the product price: "))
    return Product(name, price)

def main():
    product = get_user_input()
    print(product)

if __name__ == "__main__":
    main()







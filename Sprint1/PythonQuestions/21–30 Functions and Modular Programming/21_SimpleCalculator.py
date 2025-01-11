def add(a, b):
    return a + b

def subtract(a, b):
    return a - b

def multiply(a, b):
    return a * b

def divide(a, b):
    if b == 0:
        return "Error! Division by zero."
    else:
        return a / b

num1 = float(input("Enter the first number: "))
num2 = float(input("Enter the second number: "))
operation = input("Enter the operation (+, -, *, /): ")

if operation == '+':
    print("The result is: ", add(num1, num2))
elif operation == '-':
    print("The result is: ", subtract(num1, num2))
elif operation == '*':
    print("The result is: ", multiply(num1, num2))
elif operation == '/':
    print("The result is: ", divide(num1, num2))
else:
    print("Invalid operation.")




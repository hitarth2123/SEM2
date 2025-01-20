def divide_numbers(num1, num2):
    try:
        result = num1 / num2
        return result
    except ZeroDivisionError:
        print("Error: Division by zero is not allowed.")
    except TypeError:
        print("Error: Invalid input type.")
    finally:
        print("Division operation completed.")

print(divide_numbers(10, 2))  
divide_numbers(10, 0)  
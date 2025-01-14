num = int(input("Enter a non-negative integer: "))
if num < 0:
    print("Please enter a non-negative integer.")
else:
    factorial = 1
    for i in range(1, num + 1):
        factorial *= i
    print("The factorial of", num, "is:", factorial)


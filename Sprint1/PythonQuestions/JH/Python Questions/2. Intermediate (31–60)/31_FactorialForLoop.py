num = int(input("\nEnter a number: "))
factorial = 1
for i in range(1, num + 1):
    factorial *= i
print(f"\nThe factorial of {num} is: {factorial}")
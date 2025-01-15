def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return a
num1 = int(input("\nEnter first number: "))
num2 = int(input("\nEnter second number: "))
print("\nThe GCD of", num1, "and", num2, "is:", gcd(num1, num2))



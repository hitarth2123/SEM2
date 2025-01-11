def gcd(a, b):
    while b != 0:
        a, b = b, a % b
    return abs(a)

a = int(input("Enter the first number: "))
b = int(input("Enter the second number: "))

print("The GCD of", a, "and", b, "is", gcd(a, b))



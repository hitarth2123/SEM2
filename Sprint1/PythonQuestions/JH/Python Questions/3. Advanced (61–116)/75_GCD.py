def gcd(a, b):
    if b == 0:
        return a
    return gcd(b, a % b)

num1 = int(input("Enter the first number: "))
num2 = int(input("Enter the second number: "))
print("GCD:", gcd(num1, num2))

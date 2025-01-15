def gcd(a, b):
    while b:
        a, b = b, a % b
    return a
def lcm(a, b):
    return abs(a*b) // gcd(a, b)
num1 = int(input("\nEnter first number: "))
num2 = int(input("\nEnter second number: "))
print("\nThe LCM of", num1, "and", num2, "is", lcm(num1, num2))



def power(base, exponent):
    result = 1
    for _ in range(exponent):
        result *= base
    return result

base = float(input("Enter the base: "))
exponent = int(input("Enter the exponent: "))
print("The result is: ", power(base, exponent))






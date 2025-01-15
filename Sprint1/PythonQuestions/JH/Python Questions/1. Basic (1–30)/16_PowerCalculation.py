def power(base, exponent):
    result = 1
    for _ in range(exponent):
        result *= base
    return result

base = float(input("\nEnter the base: "))
exponent = int(input("\nEnter the exponent: "))
print("\nThe result is: ", power(base, exponent))






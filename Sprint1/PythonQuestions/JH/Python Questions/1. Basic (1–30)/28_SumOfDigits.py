n = int(input("\nEnter a number: "))
sum_of_digits = 0
while n > 0:
    digit = n % 10
    sum_of_digits += digit
    n = n // 10
print("\nSum of digits:", sum_of_digits)


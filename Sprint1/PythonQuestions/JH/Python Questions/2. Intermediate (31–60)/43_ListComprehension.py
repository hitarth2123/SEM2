lower_limit = int(input("Enter the lower limit: "))
upper_limit = int(input("Enter the upper limit: "))
squares = [x**2 for x in range(lower_limit, upper_limit + 1)]
print("\n squares value is ",squares)
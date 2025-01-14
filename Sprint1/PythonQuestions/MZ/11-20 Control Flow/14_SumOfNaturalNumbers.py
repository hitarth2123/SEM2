n = int(input("Enter a Natural Number: "))
if n > 0:
    sum_of_natural_numbers = n * (n + 1) // 2
    print("The sum of the first", n, "natural numbers is:", sum_of_natural_numbers)
else:
    print("Please enter a Natural Number.")

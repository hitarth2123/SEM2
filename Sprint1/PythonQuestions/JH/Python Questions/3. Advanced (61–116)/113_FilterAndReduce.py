from functools import reduce

# Example list
numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

# Filter out even numbers
filtered = list(filter(lambda x: x % 2 != 0, numbers))
print("Filtered odd numbers:", filtered)

# Sum the filtered numbers
sum_of_filtered = reduce(lambda x, y: x + y, filtered)
print("Sum of filtered numbers:", sum_of_filtered)

num_count = int(input("\nEnter the number of numbers: "))
numbers = [int(input(f"\nEnter number {i+1}: ")) for i in range(num_count)]
sum_of_numbers = sum(numbers)
print("\nSum of the numbers are ",sum_of_numbers)
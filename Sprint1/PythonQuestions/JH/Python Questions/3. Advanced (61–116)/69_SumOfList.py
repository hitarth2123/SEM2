def recursive_sum(lst):
    if not lst:
        return 0
    return lst[0] + recursive_sum(lst[1:])

numbers = [int(input(f"Enter the {i+1} number: ")) for i in range(int(input("Enter the number of elements: ")))]
print("Sum of list:", recursive_sum(numbers))

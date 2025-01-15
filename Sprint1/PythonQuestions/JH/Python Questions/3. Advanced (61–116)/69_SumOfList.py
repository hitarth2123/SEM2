def recursive_sum(lst):
    if not lst:
        return 0
    return lst[0] + recursive_sum(lst[1:])

numbers = [1, 2, 3, 4, 5]
print("Sum of list:", recursive_sum(numbers))

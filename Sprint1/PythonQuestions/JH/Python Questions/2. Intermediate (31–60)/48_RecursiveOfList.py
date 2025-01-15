def recursive_sum(lst):
    if len(lst) == 1:
        return lst[0]
    else:
        return lst[0] + recursive_sum(lst[1:])


user_input = input("\nEnter a list of numbers separated by spaces: ")
numbers = [float(num) for num in user_input.split()]
result = recursive_sum(numbers)
print("\nThe sum of the numbers is:", result)




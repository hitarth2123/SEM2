def linear_search(lst, target):
    for i in range(len(lst)):
        if lst[i] == target:
            return i
    return -1

lst = [int(x) for x in input("Enter a list of numbers separated by spaces: ").split()]
target = int(input("Enter the number to search for: "))
result = linear_search(lst, target)
if result != -1:
        print(f"Element {target} found at index {result}.")
else:
        print(f"Element {target} not found in the list.")



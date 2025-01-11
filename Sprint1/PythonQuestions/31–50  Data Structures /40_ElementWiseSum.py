def element_wise_sum(list1, list2):
    if len(list1) != len(list2):
        raise ValueError("Both lists must be of equal length")
    return [x + y for x, y in zip(list1, list2)]

list1 = list(map(int, input("Enter the first list of numbers separated by space: ").split()))
list2 = list(map(int, input("Enter the second list of numbers separated by space: ").split()))

print("First List: ", list1)
print("Second List: ", list2)
print("Element-wise Sum: ", element_wise_sum(list1, list2))



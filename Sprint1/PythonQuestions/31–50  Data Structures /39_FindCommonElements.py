def find_common_elements(list1, list2):
    common_elements = [element for element in list1 if element in list2]
    return common_elements

list1 = list(map(int, input("Enter the first list of numbers separated by space: ").split()))
list2 = list(map(int, input("Enter the second list of numbers separated by space: ").split()))
print("Common elements: ", find_common_elements(list1, list2))


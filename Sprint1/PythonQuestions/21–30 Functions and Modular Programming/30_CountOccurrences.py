def count_occurrences(lst, x):
    """
    This function counts the occurrences of an element in a list.
    :param lst: The list to be checked.
    :param x: The element to be counted.
    :return: The number of occurrences of the element in the list.
    """
    return lst.count(x)
lst = input("Enter a list of elements separated by space: ").split()
x = input("Enter the element to be counted: ")
print("The element", x, "appears", count_occurrences(lst, x), "times in the list.")




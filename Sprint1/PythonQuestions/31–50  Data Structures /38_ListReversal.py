def reverse_list(arr):
    arr.reverse()
    return arr

arr = list(map(int, input("Enter the list of numbers separated by space: ").split()))
print("Original List: ", arr)
print("Reversed List: ", reverse_list(arr))

def binary_search(arr, target, low, high):
    if low > high:
        return -1
    mid = (low + high) // 2
    if arr[mid] == target:
        return mid
    elif arr[mid] < target:
        return binary_search(arr, target, mid + 1, high)
    else:
        return binary_search(arr, target, low, mid - 1)

numbers = [1, 3, 5, 7, 9, 11]
target = int(input("Enter the number to search: "))
index = binary_search(numbers, target, 0, len(numbers) - 1)
if index != -1:
    print(f"Number found at index {index}.")
else:
    print("Number not found.")

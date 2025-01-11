def second_largest_element(arr):
    if len(arr) < 2:
        return "List is too small"
    largest = max(arr[0], arr[1])
    second_largest = min(arr[0], arr[1])
    for i in range(2, len(arr)):
        if arr[i] > largest:
            second_largest = largest
            largest = arr[i]
        elif arr[i] > second_largest and arr[i] != largest:
            second_largest = arr[i]
    if second_largest == min(arr):
        return "No second largest element"
    return second_largest

# Test the function
arr = list(map(int, input("Enter the list of numbers separated by space: ").split()))
print("Original List: ", arr)
print("Second largest element is: ", second_largest_element(arr))



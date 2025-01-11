def selection_sort(arr):
    for i in range(len(arr)):
        min_index = i
        for j in range(i + 1, len(arr)):
            if arr[j] < arr[min_index]:
                min_index = j
        arr[i], arr[min_index] = arr[min_index], arr[i]
    return arr

user_input = input("Enter a list of integers separated by spaces: ")
arr = [int(x) for x in user_input.split()]
sorted_arr = selection_sort(arr)
print("Sorted list: ", sorted_arr)


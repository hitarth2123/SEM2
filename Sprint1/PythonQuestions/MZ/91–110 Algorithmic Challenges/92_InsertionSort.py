def insertion_sort(arr):
    for i in range(1, len(arr)):
        key = arr[i]
        j = i - 1
        while j >= 0 and key < arr[j]:
            arr[j + 1] = arr[j]
            j -= 1
        arr[j + 1] = key
    return arr

user_input = input("Enter a list of integers separated by spaces: ")
arr = [int(x) for x in user_input.split()]
sorted_arr = insertion_sort(arr)
print("Sorted list: ", sorted_arr)






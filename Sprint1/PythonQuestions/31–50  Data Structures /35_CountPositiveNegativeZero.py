def count_positive_negative_zero(arr):
    positive_count = sum(x > 0 for x in arr)
    negative_count = sum(x < 0 for x in arr)
    zero_count = sum(x == 0 for x in arr)
    return positive_count, negative_count, zero_count

arr = list(map(int, input("Enter the list of numbers separated by space: ").split()))
positive, negative, zero = count_positive_negative_zero(arr)
print("Original List: ", arr)
print("Positive numbers: ", [x for x in arr if x > 0])
print("Positive numbers count: ", positive)
print("Negative numbers: ", [x for x in arr if x < 0])
print("Negative numbers count: ", negative)
print("Zero: ", [x for x in arr if x == 0])
print("Zero count: ", zero)



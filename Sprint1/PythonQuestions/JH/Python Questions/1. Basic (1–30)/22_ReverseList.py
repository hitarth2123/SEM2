def reverse_list_in_place(lst):
    start_index = 0
    end_index = len(lst) - 1
    while start_index < end_index:
        lst[start_index], lst[end_index] = lst[end_index], lst[start_index]
        start_index += 1
        end_index -= 1

num_count = int(input("\nEnter the number of numbers: "))
numbers = [int(input(f"\nEnter number {i+1}: ")) for i in range(num_count)]
print("\nOriginal List: ", numbers)
reverse_list_in_place(numbers)
print("\nReversed List: ", numbers)



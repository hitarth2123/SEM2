def max_min(num_list):
    max_num = max(num_list)
    min_num = min(num_list)
    return max_num, min_num

num_count = int(input("\nEnter the number of numbers: "))
num_list = [int(input(f"\nEnter number {i+1}: ")) for i in range(num_count)]
max_num, min_num = max_min(num_list)
print("\nMaximum number in the list:", max_num)
print("\nMinimum number in the list:", min_num)







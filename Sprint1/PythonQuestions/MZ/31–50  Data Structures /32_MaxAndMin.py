def find_max_min(num_list):
    max_num = max(num_list)
    min_num = min(num_list)
    return max_num, min_num

num_list = [int(x) for x in input("Enter a list of numbers separated by space: ").split()]
max_num, min_num = find_max_min(num_list)
print("Maximum number in the list:", max_num)
print("Minimum number in the list:", min_num)







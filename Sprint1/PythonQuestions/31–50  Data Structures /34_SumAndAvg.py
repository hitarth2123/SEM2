num_list = [int(x) for x in input("Enter a list of numbers separated by space: ").split()]
list_sum = sum(num_list)
list_avg = list_sum / len(num_list)
print("Sum of the list:", list_sum)
print("Average of the list:", list_avg)

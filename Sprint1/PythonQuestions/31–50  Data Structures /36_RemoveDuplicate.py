def remove_duplicates(num_list):
    unique_list = list(set(num_list))
    return unique_list

num_list = [int(x) for x in input("Enter a list of numbers separated by space: ").split()]
print("Original List: ", num_list)
print("List without duplicates: ", remove_duplicates(num_list))






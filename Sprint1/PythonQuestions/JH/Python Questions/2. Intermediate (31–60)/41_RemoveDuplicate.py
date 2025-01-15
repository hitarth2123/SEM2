def remove_duplicates(num_list):
    unique_list = list(set(num_list))
    return unique_list

num_list = [int(x) for x in input("\nEnter a list of numbers separated by space: ").split()]
print("\nOriginal List: ", num_list)
print("\nList without duplicates: ", remove_duplicates(num_list))






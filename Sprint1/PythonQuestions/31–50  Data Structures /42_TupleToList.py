def convert_tuple_to_list_and_back(input_tuple):
    list_from_tuple = list(input_tuple)
    list_from_tuple.append('new_element')
    tuple_from_list = tuple(list_from_tuple)
    return tuple_from_list

user_input = input("Enter a tuple (separated by commas): ")
input_tuple = tuple(user_input.split(','))
result = convert_tuple_to_list_and_back(input_tuple)
print("Original Tuple:", input_tuple)
print("Modified Tuple:", result)




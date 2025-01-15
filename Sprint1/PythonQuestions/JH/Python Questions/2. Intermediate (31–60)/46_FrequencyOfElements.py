def count_element_frequency(lst):
    frequency_dict = {}
    for element in lst:
        if element in frequency_dict:
            frequency_dict[element] += 1
        else:
            frequency_dict[element] = 1
    return frequency_dict

user_input = input("\nEnter a list of elements separated by space: ")
user_list = user_input.split()
frequency = count_element_frequency(user_list)
print("\nFrequency of elements in the list: ", frequency)



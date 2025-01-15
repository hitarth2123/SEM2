def invert_dict(input_dict):
    inverted_dict = {v: k for k, v in input_dict.items()}
    return inverted_dict

input_dict = {}
num_items = int(input("\nEnter the number of items in the dictionary: "))
for i in range(num_items):
    key = input(f"\nEnter key {i+1}: ")
    value = input(f"\nEnter value for key '{key}': ")
    input_dict[key] = value

print("\nOriginal Dictionary:", input_dict)
print("\nInverted Dictionary:", invert_dict(input_dict))



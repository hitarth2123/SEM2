def invert_dict(input_dict):
    inverted_dict = {v: k for k, v in input_dict.items()}
    return inverted_dict

input_dict = {}
num_items = int(input("Enter the number of items in the dictionary: "))
for i in range(num_items):
    key = input(f"Enter key {i+1}: ")
    value = input(f"Enter value for key '{key}': ")
    input_dict[key] = value

print("\nOriginal Dictionary:", input_dict)
print("Inverted Dictionary:", invert_dict(input_dict))



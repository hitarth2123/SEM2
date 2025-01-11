input_string = input("Enter a string: ")
special_characters = sum(not char.isalnum() and not char.isspace() for char in input_string)
print("Number of special characters in the string: ", special_characters)

special_chars_dict = {}
for char in input_string:
    if not char.isalnum() and not char.isspace():
        if char in special_chars_dict:
            special_chars_dict[char] += 1
        else:
            special_chars_dict[char] = 1

print("Detailed count of special characters:")
for char, count in special_chars_dict.items():
    print(f"{char}: {count}")


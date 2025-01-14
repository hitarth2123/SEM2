def count_characters(input_string):
    count = 0
    for char in input_string:
        count += 1
    return count

input_string = input("Enter a string: ")
character_count = count_characters(input_string)
print("The number of characters in the string is:", character_count)






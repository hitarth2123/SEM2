user_input = input("Please enter a string to convert to an integer: ")
if user_input.isdigit():
    integer = int(user_input)
    print(f"Successfully converted '{user_input}' to integer: {integer}")
else:
    print(f"Failed to convert '{user_input}' to integer. Please enter a valid integer.")





user_input = input("\nPlease enter a string to convert to an integer: ")
if user_input.isdigit():
    integer = int(user_input)
    print(f"\nSuccessfully converted '{user_input}' to integer: {integer}")
else:
    print(f"\nFailed to convert '{user_input}' to integer. Please enter a valid integer.")





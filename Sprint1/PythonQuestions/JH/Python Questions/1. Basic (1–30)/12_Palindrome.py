def is_palindrome(s):
    s = s.replace(" ","").lower()
    return s == s[::-1]

input_string = input("\nEnter a string: ")
if is_palindrome(input_string):
    print(f'"\n{input_string}" is a palindrome.')
else:
    print(f'"\n{input_string}" is not a palindrome.')

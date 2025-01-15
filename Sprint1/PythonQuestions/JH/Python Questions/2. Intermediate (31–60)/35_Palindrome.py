number = int(input("\nEnter a positive integer: "))
if str(number) == str(number)[::-1]:
    print("\nThe number is a palindrome.")
else:
    print("\nThe number is not a palindrome.")

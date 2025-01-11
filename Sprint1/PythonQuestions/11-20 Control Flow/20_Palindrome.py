number = int(input("Enter a positive integer: "))
temp = number
reverse = 0
while number > 0:
    remainder = number % 10
    reverse = (reverse * 10) + remainder
    number = number // 10
if temp == reverse:
    print("The number is a palindrome.")
else:
    print("The number is not a palindrome.")

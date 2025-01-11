num = int(input("Enter a positive integer: "))
if num > 0:
    for i in range(1, 11):
        print(num, 'x', i, '=', num*i)
else:
    print("Please enter a positive integer.")


n = int(input("Enter a number: "))
sum = 0
temp = n
while temp > 0:
    digit = temp % 10
    fact = 1
    for i in range(1,digit + 1):
        fact = fact * i
    sum = sum + fact
    temp = temp // 10
if sum == n:
    print(n, "is a strong number")
else:
    print(n, "is not a strong number")


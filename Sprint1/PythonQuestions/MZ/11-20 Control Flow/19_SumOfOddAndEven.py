n = int(input("Enter a positive integer: "))
even = 0
odd = 0
for i in range(1, n+1):
    if i % 2 == 0:
        even += i
    else:
        odd += i
print("The sum of even numbers from 1 to", n, "is:", even)
print("The sum of odd numbers from 1 to", n, "is:", odd)

n = int(input("Enter a number: "))

lcm = 1
for i in range(1, n + 1):
    a, b = lcm, i
    while b:
        a, b = b, a % b
    lcm = lcm * i // a

print("The LCM of the range [1..{}] is: {}".format(n, lcm))





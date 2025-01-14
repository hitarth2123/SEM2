num = int(input("Enter a number: "))
if num < 2:
    print("Not a perfect number")
else:
    divisors_sum = sum(i for i in range(1, num) if num % i == 0)
    if divisors_sum == num:
        print("Perfect number")
    else:
        print("Not a perfect number")


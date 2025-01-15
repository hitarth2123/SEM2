def fib(n):
    if n <= 1:
        return n
    return fib(n - 1) + fib(n - 2)

num = int(input("Enter the position: "))
print(f"The {num}th Fibonacci number is {fib(num)}.")

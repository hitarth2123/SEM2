def is_prime(n):
    if n < 2:
        return False
    for i in range(2, int(n**0.5) + 1):
        if n % i == 0:
            return False
    return True

def display_primes(start, end):
    for num in range(start, end + 1):
        if is_prime(num):
            print(num)

start = int(input("\nEnter the start of the range: "))
end = int(input("\nEnter the end of the range: "))
display_primes(start, end)


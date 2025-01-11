prime_factors = []
n = int(input("Enter a number: ")) 
i = 2
while i * i <= n:
    if n % i:
        i += 1
    else:
        n //= i
        prime_factors.append(i)
if n > 1:
    prime_factors.append(n)
print("Prime factors of the number are: ", prime_factors)  

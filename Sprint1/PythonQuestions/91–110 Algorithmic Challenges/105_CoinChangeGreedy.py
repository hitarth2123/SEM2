coins = list(map(int, input("Enter coin denominations separated by spaces: ").split()))
amount = int(input("Enter the amount to change: "))
coins.sort(reverse=True)
num_coins = 0
denominations_used = []  
for coin in coins:
        count = amount // coin  
        num_coins += count
        if count > 0:  
            denominations_used.append((coin,count))  
        amount %= coin
num_coins if amount == 0 else -1
print(num_coins if amount == 0 else -1)
if amount == 0:  
    print("Denominations used:", denominations_used)


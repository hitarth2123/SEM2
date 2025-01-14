def coinChangeDP(coins, amount):
    dp = [float('inf')] * (amount + 1)
    dp[0] = 0
    for coin in coins:
        for x in range(coin, amount + 1):
            dp[x] = min(dp[x], dp[x - coin] + 1)
    return dp[amount] if dp[amount] != float('inf') else -1


coins = list(map(int, input("Enter the coin denominations (space-separated): ").split()))
amount = int(input("Enter the amount: "))
result = coinChangeDP(coins, amount)
if result != -1:
        print(f"The minimum number of coins required is: {result}")
else:
        print("No combination of coins can sum up to the given amount.")


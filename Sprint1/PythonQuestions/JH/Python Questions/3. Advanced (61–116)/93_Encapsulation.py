class BankAccount:
    def __init__(self):
        self.__balance = 0  # Private attribute

    def deposit(self, amount):
        if amount > 0:
            self.__balance += amount
            print(f"Deposited: {amount}")
        else:
            print("Deposit amount must be positive.")

    def get_balance(self):
        return self.__balance

account = BankAccount()
account.deposit(100)
print(f"Balance: {account.get_balance()}")

class BankAccount:
    def __init__(self, balance=0):
        self.balance = balance

    def deposit(self, amount):
        self.balance += amount

    def withdraw(self, amount):
        if amount > self.balance:
            print("Insufficient funds")
        else:
            self.balance -= amount

    def check_balance(self):
        return self.balance

account = BankAccount(1000) 
while True:
    print("\n1. Deposit")
    print("\n2. Withdraw")
    print("\n3. Check Balance")
    print("\n4. Exit")
    choice = input("Enter your choice: ")
    if choice == "1":
        amount = float(input("Enter amount to deposit: "))
        account.deposit(amount)
    elif choice == "2":
        amount = float(input("Enter amount to withdraw: "))
        account.withdraw(amount)
    elif choice == "3":
        print("Current balance: ", account.check_balance())
    elif choice == "4":
        break
    else:
        print("Invalid choice. Please choose a valid option.")



import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

// Define classes for different account types
class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

class SavingsAccount extends Account {
    public SavingsAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
}

class CurrentAccount extends Account {
    public CurrentAccount(String accountNumber, double balance) {
        super(accountNumber, balance);
    }
}

class FixedDepositAccount extends Account {
    private int tenure;

    public FixedDepositAccount(String accountNumber, double balance, int tenure) {
        super(accountNumber, balance);
        this.tenure = tenure;
    }
}

// Define a class for transaction history
class TransactionHistory {
    private String transactionId;
    private String accountNumber;
    private double amount;
    private String transactionType;

    public TransactionHistory(String transactionId, String accountNumber, double amount, String transactionType) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public void saveTransaction() {
        try {
            FileWriter writer = new FileWriter("transaction_history.txt", true);
            writer.write("Transaction ID: " + transactionId + ", Account Number: " + accountNumber + ", Amount: " + amount + ", Transaction Type: " + transactionType + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving transaction history");
        }
    }
}

// Define a class for user registration and authentication
class User {
    private String userId;
    private String password;

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public boolean authenticate(String userId, String password) {
        return this.userId.equals(userId) && this.password.equals(password);
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Banking System!");

        System.out.print("Enter User ID: ");
        String userId = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();
        User user = new User(userId, password);

        System.out.print("Enter User ID to login: ");
        String loginUserId = scanner.next();
        System.out.print("Enter Password to login: ");
        String loginPassword = scanner.next();
        if (user.authenticate(loginUserId, loginPassword)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Invalid credentials");
            return;
        }

        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Fund Transfer");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
                        

     }
}

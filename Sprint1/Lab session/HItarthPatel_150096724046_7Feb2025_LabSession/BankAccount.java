/*
Write a Java program to create a class called "BankAccount" with instance variables  'accountNumber' and balance, and static variables 'bankName' and 'interestRate'.  Provide static methods to get and set the static variables. Create several  'BankAccount' objects and print their details along with the static variables. 
 */

import java.util.Scanner;

public class BankAccount {
    private int accountNumber;
    private double balance;
    private static String bankName = "XYZ Bank";
    private static double interestRate = 0.05;

    public BankAccount(int accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public static String getBankName() {
        return bankName;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public void printDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Bank Name: " + bankName);
        System.out.println("Interest Rate: " + interestRate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account number for account 1: ");
        int accountNumber1 = scanner.nextInt();
        System.out.println("Enter balance for account 1: ");
        double balance1 = scanner.nextDouble();
        BankAccount account1 = new BankAccount(accountNumber1, balance1);

        System.out.println("Enter account number for account 2: ");
        int accountNumber2 = scanner.nextInt();
        System.out.println("Enter balance for account 2: ");
        double balance2 = scanner.nextDouble();
        BankAccount account2 = new BankAccount(accountNumber2, balance2);

        System.out.println("Enter account number for account 3: ");
        int accountNumber3 = scanner.nextInt();
        System.out.println("Enter balance for account 3: ");
        double balance3 = scanner.nextDouble();
        BankAccount account3 = new BankAccount(accountNumber3, balance3);

        System.out.println("Bank Details:");
        System.out.println("Bank Name: " + BankAccount.getBankName());
        System.out.println("Interest Rate: " + BankAccount.getInterestRate());

        System.out.println("\nAccount 1 Details:");
        account1.printDetails();

        System.out.println("\nAccount 2 Details:");
        account2.printDetails();

        System.out.println("\nAccount 3 Details:");
        account3.printDetails();

        scanner.close();
    }
}
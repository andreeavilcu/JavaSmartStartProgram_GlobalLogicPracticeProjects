package org.example;

public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance){
        if (initialBalance < 0 ){
            throw new IllegalArgumentException("The initial balance can't be negative");

        }
        this.balance = initialBalance;
    }

    public void deposit(double amount){
        if (amount < 0){
            throw new IllegalArgumentException("Deposit amount cannot be negative");
        }
        balance += amount;
        System.out.println("Deposit successful: "+ amount +" USD. Current balance: " + balance + " USD.");
    }

    public void withdraw(double amount) throws InsufficientFundsException{
        if (amount < 0){
            throw new IllegalArgumentException("Withdrawal amount cannot be negative.");

        }

        if(amount > balance){
            throw new InsufficientFundsException("Insufficient funds! Current balance: "+ balance + " USD");
        }

        balance-= amount;
        System.out.println("Withdrawal successful: " + amount + " USD. Current balance: " + balance + " USD.");
    }

    public double getBalance() {
        return balance;
    }
}

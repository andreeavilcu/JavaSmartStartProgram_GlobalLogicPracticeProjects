package org.example.Lab2;

public class BankAccount {
    private int balance = 100;

    public synchronized void withdraw(int amount){
        if (balance >= amount){
            System.out.println(Thread.currentThread().getName() + " withdraws " + amount);
            balance -= amount;
        } else {
            System.out.println(Thread.currentThread().getName() + " insufficient funds!");
        }
    }
}

package org.example.Lab2;

// Synchronization
// Create a BankAccount class.
// Two threads should try to withdraw money at the same time.
// Use synchronization to avoid inconsistent balance.
public class Lab2 {
    public static void main(String[] args){
        BankAccount account = new BankAccount();

        Runnable task = () -> {
            for (int i = 0; i < 3; i++){
                account.withdraw(30);
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}

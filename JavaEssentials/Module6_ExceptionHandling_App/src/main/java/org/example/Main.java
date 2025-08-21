package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount(500);

        try{
            ba.deposit(0);
            ba.deposit(200);
            ba.withdraw(100);
            ba.withdraw(700);
        } catch (IllegalArgumentException e){
            System.out.println("Error: " + e.getMessage());
        } catch (InsufficientFundsException e ){
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Final balance: " + ba.getBalance() + " USD.");
    }
}
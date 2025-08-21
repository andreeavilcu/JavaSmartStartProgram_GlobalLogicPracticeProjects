package org.example;

public class PaymentGatewayApp {
    public static void main(String[] args){
        processPayment();
    }

    public static void processPayment(){
        try{
            // Code for processing payment
            int totalAmount = 1000;
            int numberOfItems = 0;
            int amountPerItem = totalAmount/ numberOfItems;
            System.out.println("Amount per item: " + amountPerItem);

        } catch (ArithmeticException e){
            System.out.println("Payment failed: Division by zero is not allowed.");
        } finally {
            System.out.println("Payment processing completed.");
        }
    }
}

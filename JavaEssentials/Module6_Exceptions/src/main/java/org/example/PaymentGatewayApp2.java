package org.example;

public class PaymentGatewayApp2 {
    public static void main(String[] args){
        try{
            processPayment(1200);
        } catch (PaymentFailedException e) {
            System.out.println("Payment failed: "+ e.getMessage());
        }
    }

    public static void processPayment(int amount) throws PaymentFailedException {
        if(amount <= 0){
            throw new PaymentFailedException("Invalid payment amount. Amount should be reater than zero.");
        }

        try{
            //Simulating a payment failure scenario
            throw new PaymentFailedException("Insufficient funds. Payment failed.");

        } catch (PaymentFailedException e) {
            throw new PaymentFailedException("Payment failed: "+ e.getMessage());
        }

    }
}

class PaymentFailedException extends Exception{
    public PaymentFailedException(String message){
        super(message);
    }
}

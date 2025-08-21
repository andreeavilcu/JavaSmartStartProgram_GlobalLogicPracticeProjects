package org.example;

public class InvalidCustomerException extends RuntimeException{
    public InvalidCustomerException(String message){
        super(message);
    }
}

package org.example;

public class ExceptionHandlingExample {
    void performDivision(){
        int dividend = 20;
        int divisor = 0;
        System.out.println(dividend / divisor);
    }

    void performCalculation(){
        try{
            performDivision();
        } catch (ArithmeticException ae){
            System.out.println("Exception is caught");
        }
    }
    public static void main(String args[]){
        ExceptionHandlingExample obj = new ExceptionHandlingExample();
        obj.performCalculation();
    }
}

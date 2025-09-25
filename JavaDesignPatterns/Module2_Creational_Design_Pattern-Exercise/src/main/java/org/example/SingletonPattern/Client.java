package org.example.SingletonPattern;

public class Client {
    public static void main(String[] args){
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("First log message");
        logger2.log("Second log message");

        System.out.println("logger1 == logger2 ? " + (logger1 == logger2));
    }
}

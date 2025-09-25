package org.example.SingletonPattern;

import java.io.Serializable;

public class Logger implements Serializable, Cloneable {
    private static volatile Logger instance;

    private Logger() {
        System.out.println("Logger initialized...");
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }

        return instance;
    }

    public void log(String message){
        System.out.println("[LOG] " + message);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        throw new CloneNotSupportedException("Cannot clone singleton object");
    }

    protected Object readResolve(){
        return getInstance();
    }

}
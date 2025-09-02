package org.example;

//Write a program to print numbers from 1–10 using two threads.
public class Lab1 {
    public static void main(String[] args) {
        Runnable printNumbers = () -> {
            for (int i = 0; i< 10; i++){
                System.out.println(Thread.currentThread().getName() + " -> " + i);
                try {
                    Thread.sleep(100);
                } catch( InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(printNumbers, "Thread-1");
        Thread t2 = new Thread(printNumbers, "Thread-2");

        t1.start();
        t2.start();
    }
}
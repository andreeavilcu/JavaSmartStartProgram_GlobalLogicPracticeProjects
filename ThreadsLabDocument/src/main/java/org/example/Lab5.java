package org.example;

//
public class Lab5 {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args){
        Thread t1 = new Thread( () -> {
            synchronized (lock1){
                System.out.println("Thread 1 holds lock1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
                synchronized (lock2) {
                    System.out.println("Thread-1 holds lock2");
                }
            }
        });

        Thread t2 = new Thread( () -> {
            synchronized (lock2){
                System.out.println("Thread 2 holds lock2");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {}
                synchronized (lock2) {
                    System.out.println("Thread-2 holds lock1");
                }
            }
        });

        t1.start();
        t2.start();
    }

}

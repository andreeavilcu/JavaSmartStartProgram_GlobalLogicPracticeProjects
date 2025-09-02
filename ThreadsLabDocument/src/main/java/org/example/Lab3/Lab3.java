package org.example.Lab3;
// Lab 3: Producer-Consumer Problem
//Implement Producer-Consumer using wait() and notify().
// Producer adds items to a list, Consumer removes items.

public class Lab3 {
    public static void main(String[] args){
        SharedQueue queue = new SharedQueue();

        Thread producer = new Thread( () -> {
            for (int i = 1; i<= 10; i++){
                try{
                    queue.produce(i);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread( () -> {
            for (int i = 1; i<= 10; i++){
                try{
                    queue.consume();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }
}

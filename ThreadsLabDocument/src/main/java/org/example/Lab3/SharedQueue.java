package org.example.Lab3;

import java.util.LinkedList;
import java.util.Queue;

public class SharedQueue {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int CAPACITY = 5;

    public synchronized void produce(int value) throws InterruptedException{
        while (queue.size() == CAPACITY){
            wait();
        }
        queue.add(value);
        System.out.println("Produced: " + value);
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException{
        while (queue.isEmpty()){
            wait();
        }

        int value = queue.poll();
        System.out.println("Consumed: " + value);
        notifyAll();
    }
}

package org.example;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class TaskRunnable implements Runnable{
    private static final Random random = new Random();

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        int sleepTime = 1 + random.nextInt(5);

        System.out.println("Task runnin on " + threadName + " | Sleeping for " + sleepTime + " seconds");

        try{
            TimeUnit.SECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.println(threadName + " was interrupted!");
            Thread.currentThread().interrupt();
        }

        System.out.println("Task finished on " + threadName);

    }
}

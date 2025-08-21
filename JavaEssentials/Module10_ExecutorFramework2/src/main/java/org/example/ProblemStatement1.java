package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProblemStatement1 {
    public static void main(String[] args){
        ExecutorService  executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++){
            executorService.submit(new TaskRunnable());
        }

        executorService.shutdown();

        try{
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)){
                System.out.println("All tasks finished.");
            } else {
                System.out.println("Timeout occurred before all tasks finished");
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted while waiting");
            Thread.currentThread().interrupt();
        }
    }
}

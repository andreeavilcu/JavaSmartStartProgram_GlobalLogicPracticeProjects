package org.example;

import java.util.concurrent.*;

//ExecutorService
// Submit multiple tasks to a thread pool.
// Use Callable to return results.
public class Lab4 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> task1 = () -> {
            int sum = 0;
            for (int i = 1; i <= 5; i++){
                sum += i;
            }
            return sum;
        };

        Callable<Integer> task2 = () -> {
            int prod = 1;
            for (int i = 1; i <= 5; i++) prod *= i;
            return prod;
        };

        Future<Integer> result1 = executor.submit(task1);
        Future<Integer> result2 = executor.submit(task2);

        System.out.println("Sum result: " + result1.get());
        System.out.println("Product result: " + result2.get());

        executor.shutdown();
    }
}

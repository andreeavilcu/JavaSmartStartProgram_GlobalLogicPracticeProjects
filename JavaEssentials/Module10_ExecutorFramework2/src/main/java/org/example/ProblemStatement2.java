package org.example;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class ProblemStatement2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        List<Future<Integer>> futures = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            TaskCallable task = new TaskCallable(i * 10); // ex: 10, 20, 30 ... 100
            Future<Integer> future = executorService.submit(task);
            futures.add(future);
        }

        executorService.shutdown();

        for(Future<Integer> future : futures){
            try{
                Integer result = future.get();
                System.out.println("Rezultat primit: " + result);

            }catch(InterruptedException e){
                System.err.println("Execuția a fost întreruptă: " + e.getMessage());
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                System.err.println("Eroare la execuția task-ului: " + e.getCause());
            }
        }
    }
}
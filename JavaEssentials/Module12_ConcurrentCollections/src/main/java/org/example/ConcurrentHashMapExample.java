package org.example;
import java.util.concurrent.*;

public class ConcurrentHashMapExample {
    public static void main(String[] args){
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        class Task implements Runnable {
            private final int id;

            public Task(int id){
                this.id = id;
            }

            @Override
            public void run() {
                String key = "Key-" +id;
                map.put(key, id);
                System.out.println(Thread.currentThread().getName() + " added " + key);
            }
        }

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 100; i++){
            executor.submit(new Task(i));
        }

        executor.shutdown();
        try{
            if(!executor.awaitTermination(60, TimeUnit.SECONDS)){
                executor.shutdown();
            }

        } catch (InterruptedException e){
            executor.shutdown();
        }

        System.out.println("Final size of ConcurrentHashMap: " + map.size());
    }
}

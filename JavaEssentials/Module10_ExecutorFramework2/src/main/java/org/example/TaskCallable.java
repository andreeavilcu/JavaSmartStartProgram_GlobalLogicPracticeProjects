package org.example;

import java.util.concurrent.Callable;

public class TaskCallable implements Callable<Integer> {
    private final int number;

    public TaskCallable(int number){
        this.number = number;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for(int i = 1; i <= number; i++){
            sum+= i;
        }
        System.out.println(Thread.currentThread().getName() + "calculated sum for " + number + " = " + sum);

        return sum;
    }


}

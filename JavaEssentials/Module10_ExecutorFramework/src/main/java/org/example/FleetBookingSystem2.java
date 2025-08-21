package org.example;

import java.util.concurrent.*;

public class FleetBookingSystem2 implements Runnable {
    public static int availableFleets = 0;
    private static final Object lock = new Object();
    private int requiredFleets;
    private boolean booking;

    public FleetBookingSystem2(int requiredFleets, boolean booking){
        this.requiredFleets = requiredFleets;
        this.booking = booking;
    }

    @Override
    public void run() {
        if(booking){
            try{
                bookSeat(requiredFleets);
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        } else {
            cancelSeat(requiredFleets);
        }
    }

    public void bookSeat (int requiredFleets) throws InterruptedException {
        synchronized (lock) {
            while (availableFleets < requiredFleets) {
                System.out.println("No fleets available.Waiting for cancellation.");
                lock.wait();
            }

            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("Your fleets are booked.");
                availableFleets = availableFleets - requiredFleets;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void cancelSeat(int requiredFleets){
        synchronized (lock){
            try {
                TimeUnit.SECONDS.sleep(2);
                availableFleets = availableFleets + requiredFleets;
                System.out.println("Seat canceled successfully.");
                lock.notify();

            } catch(InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args){

//        Executor executor = Executors.newFixedThreadPool(2);
//        for (int i = 0 ; i < 50; i++){
//            FleetBookingSystem bookingSystem = new FleetBookingSystem(4, true);
//            FleetBookingSystem cancellationSystem  = new FleetBookingSystem(4,false);
//
//            executor.execute(bookingSystem);
//            executor.execute(cancellationSystem);
//        }


        ExecutorService executorService = Executors.newFixedThreadPool(50);
        for (int i = 0 ; i < 5; i++){
            FleetBookingSystem bookingSystem = new FleetBookingSystem(4, true);
            FleetBookingSystem cancellationSystem  = new FleetBookingSystem(4,false);

            executorService.execute(bookingSystem);
            executorService.execute(cancellationSystem);
        }
        executorService.shutdown();

        System.out.println("All tasks completed");
    }
    //Using shutdown() method of ExecutorServiceInterface, Alex shutdown the
    //executor after all the submitted tasks were executed by the thread pool

}

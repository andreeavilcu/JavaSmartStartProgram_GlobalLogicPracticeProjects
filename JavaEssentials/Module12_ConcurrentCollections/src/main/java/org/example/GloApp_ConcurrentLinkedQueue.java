package org.example;

import java.util.concurrent.ConcurrentLinkedQueue;

public class GloApp_ConcurrentLinkedQueue {
    private ConcurrentLinkedQueue<String> requests;

    public GloApp_ConcurrentLinkedQueue(){
        requests = new ConcurrentLinkedQueue<>();
    }

    public void addRequest(String request){
        requests.add(request);
    }

    public void processRequests(){
        requests.parallelStream().forEach(this::processRequest);
    }

    private void processRequest(String request){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();;
        }
        System.out.println("Processed request: " + request);
    }

    public static void main(String[] args){
        GloApp_ConcurrentLinkedQueue app = new GloApp_ConcurrentLinkedQueue();
        //request urile se executa in paralel
        app.addRequest("Request 1");
        app.addRequest("Request 2");
        app.addRequest("Request 3");
        app.addRequest("Request 4");
        app.addRequest("Request 5");
        app.processRequests();
    }
}

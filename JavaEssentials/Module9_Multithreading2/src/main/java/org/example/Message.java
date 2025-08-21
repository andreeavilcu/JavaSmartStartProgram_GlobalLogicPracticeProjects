package org.example;

public class Message {
    private String content;
    private boolean hasMessage = false;

    public synchronized void send(String msg) {
        while (hasMessage) {
            try { wait(); } catch (InterruptedException e) {}
        }

        content = msg;
        hasMessage = true;
        notifyAll();
    }

    public synchronized String receive() {
        while(!hasMessage){
            try { wait(); } catch (InterruptedException e) {}
        }

        hasMessage = false;
        notifyAll();
        return content;
    }


}

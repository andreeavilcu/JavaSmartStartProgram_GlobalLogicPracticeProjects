package org.example;

public class Server implements Runnable {
    private Message message;

    public Server(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        while (true) {
            String msg = message.receive();
            System.out.println("Server received: " + msg);

            String reply = "Echo: " + msg;
            message.send(reply);
        }

    }

    public Message getMessage() {
        return message;
    }
}

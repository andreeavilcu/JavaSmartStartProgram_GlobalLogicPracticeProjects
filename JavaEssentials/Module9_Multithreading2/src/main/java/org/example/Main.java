package org.example;

public class Main {
    public static void main(String[] args) {
        Message sharedMessage = new Message();

        Thread serverThread = new Thread(new Server(sharedMessage));
        Thread client1 = new Thread(new Client("Client1", sharedMessage));
        Thread client2 = new Thread(new Client("Client2", sharedMessage));

        serverThread.start();
        client1.start();
        client2.start();
    }
}
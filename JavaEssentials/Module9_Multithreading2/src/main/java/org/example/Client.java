package org.example;

public class Client implements Runnable {
    private String name;
    private Message message;

    public Client(String name, Message message) {
        this.name = name;
        this.message = message;
    }


    @Override
    public void run() {
        for (int i = 1; i <= 3; i++){
            message.send(name + " says hello " + i);
            String reply = message.receive(); // primește răspuns
            System.out.println(name + " got reply: " + reply);
        }

    }

}

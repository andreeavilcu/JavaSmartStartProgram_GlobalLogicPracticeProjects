package org.example;

public class DatabaseConnection {
    private final int id;
    private boolean inUse;


    public DatabaseConnection(int id) {
        this.id = id;
        this.inUse =  false;
    }

    public void connect(){
        System.out.println("Connection " + id + " established.");
    }

    public void disconnect(){
        System.out.println("Connection " + id + " closed.");
    }

    public void execute(String query){
        System.out.println("Connection " + id + " executing: " + query);
    }

    public int getId() {
        return id;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }
}

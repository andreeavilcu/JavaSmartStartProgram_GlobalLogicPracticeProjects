package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPool {
    private final Queue<DatabaseConnection> availableConnections = new LinkedList<>();
    private final int poolSize;

    public ConnectionPool(int poolSize) {
        this.poolSize = poolSize;
        for (int i = 1; i <= poolSize; i++) {
            availableConnections.add(new DatabaseConnection(i));
        }
    }

    public synchronized DatabaseConnection getConnection(){
        if (availableConnections.isEmpty()){
            System.out.println("No available connections. Please wait...");
            return null;
        }

        DatabaseConnection connection = availableConnections.poll();
        connection.setInUse(true);
        connection.connect();
        return connection;
    }

    public synchronized void releaseConnection(DatabaseConnection connection){
        if (connection != null){
            connection.disconnect();
            connection.setInUse(false);
            availableConnections.add(connection);
            System.out.println("Connection " + connection.getId() + " released back to pool.");
        }
    }


}

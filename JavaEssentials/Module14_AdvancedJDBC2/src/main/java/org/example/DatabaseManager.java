package org.example;

public class DatabaseManager {
    private final ConnectionPool pool;


    public DatabaseManager(ConnectionPool pool) {
        this.pool = pool;
    }

    public void performOperation(String query){
        DatabaseConnection connection = pool.getConnection();
        if (connection != null){
            try{
                connection.execute(query);
            } finally {
                pool.releaseConnection(connection);
            }
        }
    }
}

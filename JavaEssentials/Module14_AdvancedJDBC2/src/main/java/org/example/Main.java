package org.example;


public class Main {
    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool(2);
        DatabaseManager dbManager = new DatabaseManager(pool);

        dbManager.performOperation("SELECT * FROM product");
        dbManager.performOperation("UPDATE product SET stock = stock + 10 WHERE id = 1");

        DatabaseConnection c1 = pool.getConnection();
        DatabaseConnection c2 = pool.getConnection();
        DatabaseConnection c3 = pool.getConnection();

        if (c3 == null) {
            System.out.println("No free connection available for c3!");
        }

        pool.releaseConnection(c1);
        pool.releaseConnection(c2);

        c3 = pool.getConnection();
        if (c3 != null) {
            c3.execute("DELETE FROM product WHERE id = 2");
            pool.releaseConnection(c3);
        }
    }
}
package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionManagementDemo {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5433/glologisticsdb";
        String username = "postgres";
        String password = "1q2w3e";

        try (Connection connection = DriverManager.getConnection(url, username, password)){
            ProductDao productDao = new ProductDao(connection);

            productDao.addStock(1,50);

            productDao.reduceStock(1, 20);

            productDao.reduceStock(1, 1000);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

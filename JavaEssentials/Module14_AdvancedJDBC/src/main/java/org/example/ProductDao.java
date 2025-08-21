package org.example;

import java.sql.*;

public class ProductDao {
    private Connection connection;


    public ProductDao(Connection connection) {
        this.connection = connection;
    }

    public void addStock(int id, int amount) throws SQLException {
        String sql = "UPDATE product SET stock = stock + ? WHERE id =  ?";
        try(PreparedStatement pstmt = connection.prepareStatement(sql)){
            pstmt.setInt(1, amount);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            System.out.println("Stock increased for product " + id);
        }
    }

    public void reduceStock(int id, int amount) throws SQLException{
        connection.setAutoCommit(false);
        try{
            String selectSQL = "SELECT stock FROM product WHERE id = ? FOR UPDATE";
            try (PreparedStatement pstmt = connection.prepareStatement(selectSQL)){
                pstmt.setInt(1,id);
                ResultSet rs = pstmt.executeQuery();

                if(rs.next()) {
                    int currentStock = rs.getInt("stock");
                    if (currentStock >= amount){
                        String updateSQL = "UPDATE product SET stock = stock - ? WHERE id = ?";
                        try(PreparedStatement updateStmt = connection.prepareStatement(updateSQL)){
                            updateStmt.setInt(1, amount);
                            updateStmt.setInt(2,id);
                            updateStmt.executeUpdate();
                            connection.commit();
                            System.out.println("Stock reduced for product " + id);
                        }
                    } else {
                        System.out.println("Not enough stock for product " + id + ". Rolling back...");
                        connection.rollback();
                    }

                } else {
                    System.out.println("Product not found with id: " + id);
                    connection.rollback();
                }
            }
        } catch (SQLException e){
            connection.rollback(); // rollback on error
            throw e;
        } finally {
            connection.setAutoCommit(true);
        }

    }
}

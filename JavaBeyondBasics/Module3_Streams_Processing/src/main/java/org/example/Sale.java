package org.example;

import java.time.LocalDate;

public class Sale {
    private String productName;
    private double amount;
    private String customerId;
    private LocalDate date;

    public Sale(String productName, double amount, String customerId, LocalDate date) {
        this.productName = productName;
        this.amount = amount;
        this.customerId = customerId;
        this.date = date;
    }

    public String getProductName() {
        return productName;
    }

    public double getAmount() {
        return amount;
    }

    public String getCustomerId() {
        return customerId;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString(){
        return "Sale("  + productName + ", " + amount + ", "+ customerId + ", " + date +")" + "\n";
    }
}


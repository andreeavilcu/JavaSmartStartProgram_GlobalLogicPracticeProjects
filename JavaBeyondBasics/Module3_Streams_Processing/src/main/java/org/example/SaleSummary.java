package org.example;

public class SaleSummary {
    private String productName;
    private double totalAmount;

    public SaleSummary(String productName, double totalAmount) {
        this.productName = productName;
        this.totalAmount = totalAmount;
    }

    public String getProductName() {
        return productName;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return productName + ": $" + totalAmount + "\n";
    }
}

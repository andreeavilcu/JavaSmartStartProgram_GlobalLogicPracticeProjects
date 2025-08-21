package org.example;

public class ShipmentOrder {
    private String origin;
    private String destination;
    private double weight;
    private String customerName;
    private int orderId;


    public ShipmentOrder(String origin, String destination, double weight, String customerName, int orderId) {
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
        this.customerName = customerName;
        this.orderId = orderId;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getOrderId() {
        return orderId;
    }
}

package org.example;

public abstract class ShipmentOrder {
    protected String orderId;
    protected String origin;
    protected String destination;
    protected double weight;

    public ShipmentOrder(String orderId, String origin, String destination, double weight) {
        this.orderId = orderId;
        this.origin = origin;
        this.destination = destination;
        this.weight = weight;
    }

    public abstract void generateBill();
}

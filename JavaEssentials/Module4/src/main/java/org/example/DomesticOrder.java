package org.example;

public class DomesticOrder extends ShipmentOrder {
    private String pinCode;

    public DomesticOrder(String orderId, String origin, String destination, double weight, String pincode) {
        super(orderId, origin, destination, weight);
        this.pinCode = pincode;
    }

    @Override
    public void generateBill() {
        System.out.println("Domestic Order Bill:");
        System.out.println("Order ID: " + orderId);
        System.out.println("Origin: " + origin);
        System.out.println("Destination: " + destination);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Pincode: " + pinCode);
        // Generate the rest of the bill
    }
}

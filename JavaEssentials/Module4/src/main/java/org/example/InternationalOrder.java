package org.example;

class InternationalOrder extends ShipmentOrder {
    private String countryCode;

    public InternationalOrder(String orderId, String origin, String destination, double weight, String countryCode) {
        super(orderId, origin, destination, weight);
        this.countryCode = countryCode;
    }

    @Override
    public void generateBill() {
        System.out.println("International Order Bill:");
        System.out.println("Order ID: " + orderId);
        System.out.println("Origin: " + origin);
        System.out.println("Destination: " + destination);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Country Code: " + countryCode);
        // Generate the rest of the bill
    }
}


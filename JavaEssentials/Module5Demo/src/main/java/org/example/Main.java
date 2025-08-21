package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ShipmentOrderService orderService = new ShipmentOrderService();

        String origin = "BLR";
        String destination = "Noida";
        double weight = 300.0;
        String customerName = "John Doe";
        int orderId = 12345;

        boolean isValidCustomerName = orderService.isValidCustomerName(customerName);
        System.out.println("Is Customer Name Valid? " + (isValidCustomerName ? "Valid" : "Invalid"));

        // Validate order ID
        boolean isValidOrderId = orderService.isValidOrderId(orderId);
        System.out.println("Is Order ID Valid? " + (isValidOrderId ? "Valid" : "Invalid"));

        if (isValidCustomerName && isValidOrderId) {
            System.out.println("Shipment Order created successfully:\n");
        } else {
            System.out.println("Invalid data. Shipment Order not created.");
        }

    }
}
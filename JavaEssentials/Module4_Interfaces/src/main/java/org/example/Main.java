package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AirShipment airShipment = new AirShipment("12345", "BANGALORE", "MUMBAI", 3.5, "John Doe", Status.SHIPPED);
        SeaShipment seaShipment = new SeaShipment("67890", "PUNE", "CHENNAI", 2.8, "Jane Doe", Status.SHIPPED);

        airShipment.createOrder();
        seaShipment.createOrder();

        airShipment.cancelOrder();
        seaShipment.cancelOrder();

        System.out.println("Air Shipment Order Status: " + airShipment.getOrderStatus());
        System.out.println("Sea Shipment Order Status: " + seaShipment.getOrderStatus());


    }
}
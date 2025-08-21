package org.example;

class SeaShipment implements ShipmentOrderOperations {
    private ShipmentOrder shipmentOrder;

    public SeaShipment(String orderId, String origin, String destination, double weight, String customer_Name, Status status) {
        this.shipmentOrder = new ShipmentOrder(orderId, origin, destination, weight, customer_Name, status);
    }

    @Override
    public void createOrder() {
        shipmentOrder.createOrder();
        System.out.println("Sea Shipment Order created.");
    }

    @Override
    public void cancelOrder() {
        shipmentOrder.cancelOrder();
        System.out.println("Sea Shipment Order canceled.");
    }

    @Override
    public String getOrderStatus() {
        return shipmentOrder.getOrderStatus();
    }
}

package org.example;

public class ShipmentOrder {
    private int orderId;
    private String recipientName;
    private String shippingStatus;

    public ShipmentOrder(int orderId, String recipientName, String shippingStatus) {
        this.orderId = orderId;
        this.recipientName = recipientName;
        this.shippingStatus = shippingStatus;
    }


    public int getOrderId() {
        return orderId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getShippingStatus() {
        return shippingStatus;
    }
}

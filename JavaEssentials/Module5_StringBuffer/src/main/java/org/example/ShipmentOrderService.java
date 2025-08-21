package org.example;
import java.util.ArrayList;
import java.util.List;

public class ShipmentOrderService {
    private List<ShipmentOrder> shippedOrders;

    public ShipmentOrderService(){
        shippedOrders = new ArrayList<>();
        shippedOrders.add(new ShipmentOrder(1001, "John Doe", "Shipped"));
        shippedOrders.add(new ShipmentOrder(1002, "Jane Smith", "Delivered"));
        shippedOrders.add(new ShipmentOrder(1003, "Mike Johnson", "In Transit"));
    }

    public StringBuffer generateShippedOrdersReport() {
        StringBuffer reportBuffer = new StringBuffer();
        for (ShipmentOrder order : shippedOrders) {
            reportBuffer.append("Order ID: ").append(order.getOrderId()).append("\n");
            reportBuffer.append("Recipient Name: ").append(order.getRecipientName()).append("\n");
            reportBuffer.append("Shipping Status: ").append(order.getShippingStatus()).append("\n");
            reportBuffer.append("\n"); // Add a separator between orders

        }

        return reportBuffer;

    }
}

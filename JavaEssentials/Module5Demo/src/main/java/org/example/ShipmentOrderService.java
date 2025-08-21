package org.example;

public class ShipmentOrderService {
    public boolean isValidCustomerName(String customerName){
        return customerName != null && customerName.length() >= 3 && customerName.matches("[A-Za-z\\s]+");
    }

    public boolean isValidOrderId(int id){
        String idString = Integer.toString(id);
        return id > 0 && idString.matches("\\d{5}");
    }
}

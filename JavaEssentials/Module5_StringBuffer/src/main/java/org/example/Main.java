package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ShipmentOrderService system = new ShipmentOrderService();
        StringBuffer shippedOrdersReport = system.generateShippedOrdersReport();
        System.out.println(shippedOrdersReport.toString());
    }
}
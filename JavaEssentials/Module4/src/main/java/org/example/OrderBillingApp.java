package org.example;

public class OrderBillingApp {
    public static void main(String[] args) {
        InternationalOrder intlOrder = new InternationalOrder("123", "CityA", "CityB", 2.5, "INTL");
        intlOrder.generateBill();

        System.out.println("-----------------------------------------");

        DomesticOrder domOrder = new DomesticOrder("456", "CityX", "CityY", 1.8, "123456");
        domOrder.generateBill();
    }
}

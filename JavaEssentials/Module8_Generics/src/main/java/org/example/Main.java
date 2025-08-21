package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Box<String> box1 = new Box<>("Hello");
        Box<Integer> box2 = new Box<>(123);

        Shipment<String> stringShipment = new Shipment<>();
        stringShipment.addBox(box1);

        Shipment<Integer> intShipment = new Shipment<>();
        intShipment.addBox(box2);

        System.out.println("Box1 cu 'Hello' si 'World' -> " + box1.inspect("World")); // true
        System.out.println("Box1 cu 'Hello' si 10 -> " + box1.inspect(10));           // false

        System.out.println("stringShipment cu 'Salut' -> " + stringShipment.inspectShipment("Salut")); // true
        System.out.println("stringShipment cu 10 -> " + stringShipment.inspectShipment(10));           // false
        System.out.println("intShipment cu 456 -> " + intShipment.inspectShipment(456));               // true
    }
}
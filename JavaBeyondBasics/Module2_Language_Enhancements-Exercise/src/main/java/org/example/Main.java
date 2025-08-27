package org.example;


public class Main {
    public static void main(String[] args) {
        OnlineOrderProcessor processor = new OnlineOrderProcessor();
        Cart cart = new Cart();

        Item item1 = new Item("Laptop", 1200);
        Item item2 = new Item("Headphones", 200);
        Item item3 = new Item("Mouse", 50);

        processor.addItem(cart, item1);
        processor.addItem(cart, item2);
        processor.addItem(cart, item3);
        

        double total = processor.calculateTotal(cart);
        System.out.println("Total before discount: " + total);

        double discounted = processor.calculateTotalWithDiscount(cart, 15);
        System.out.println("Total with 15% discount: " + discounted);

        double customDiscounted = processor.applyStandardDiscount(total);
        System.out.println("Total with overridden standard discount: " + customDiscounted);
    }
}
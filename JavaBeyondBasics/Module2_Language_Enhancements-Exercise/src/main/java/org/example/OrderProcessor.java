package org.example;

public interface OrderProcessor extends DiscountCalculator{
    default void addItem(Cart cart, Item item){
        cart.getItems().add(item);
        System.out.println(item.getName() + " added to cart.");
    }

    default void removeItem(Cart cart, Item item){
        cart.getItems().remove(item);
        System.out.println(item.getName() + " removed from cart.");
    }

    default double calculateTotal(Cart cart){
        return cart.getItems().stream().mapToDouble(Item::getPrice).sum();

    }

    default double calculateTotalWithDiscount(Cart cart, double percent){
        double total = calculateTotal(cart);

        return DiscountCalculator.percentageDiscount(total, percent);
    }
}

package org.example;

public class OnlineOrderProcessor implements OrderProcessor{
    @Override
    public double applyStandardDiscount(double total){
        return DiscountCalculator.percentageDiscount(total, 20);
    }
}

package org.example;

import java.util.List;

public interface DiscountCalculator {
    static double percentageDiscount(double total, double percent){
        return total - (total * percent / 100);
    }

    static double buyOneGetOneFree(List<Item> items){
        double total = 0.0;

        for (int i = 0; i< items.size(); i++){
            if(i %2 == 0){
                total += items.get(i).getPrice();
            }
        }

        return total;
    }

    default double applyStandardDiscount(double total){
        return percentageDiscount(total, 10);
    }
}

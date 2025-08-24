package org.example;

public class Main {
    public static void main(String[] args) {
       CategorizeMenuItem categorize = item -> {
           switch (item.getCategory().toLowerCase()){
               case "appetizer":
                   return "Appetizer";
               case "main":
                   return "Main Course";
               case "dessert":
                   return "Dessert";
               default:
                   return "Unknown";
           }
       };

       MenuItem item1 = new MenuItem("Cheeseburger", 8.5, "main");
       System.out.println(categorize.categorize(item1));


       ApplySpecialOffer specialOffer = item -> {
           switch (item.getCategory().toLowerCase()){
               case "main": return item.getPrice() * 0.9;
               case "dessert": return item.getPrice() * 0.8;
               default: return item.getPrice();
           }
       };

        System.out.println(specialOffer.apply(item1));
    }

    CategorizeMenuItem safeCategorize = item -> {
        switch (item.getCategory().toLowerCase()) {
            case "appetizer": return "Appetizer";
            case "main": return "Main Course";
            case "dessert": return "Dessert";
            default: return "Unknown Category";
        }
    };

    MenuItem item2 = new MenuItem("ChickenSoup", 8.5, "Soups");
   
}
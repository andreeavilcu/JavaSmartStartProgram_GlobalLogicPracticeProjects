package org.example.BuilderPattern;

public class Client {
    public static void main(String[] args){
        Car car1 = new Car.CarBuilder()
                .brand("Toyota").model("Corolla").color("Red")
                .engine("V4").transmission("Automatic")
                .build();

        Car car2 = new Car.CarBuilder()
                .brand("Tesla").model("Model S").color("Black")
                .engine("Electric").transmission("Automatic").fuelType("Electric")
                .build();

        System.out.println(car1);
        System.out.println(car2);
    }
}

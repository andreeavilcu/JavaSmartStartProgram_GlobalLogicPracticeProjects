package org.example.FactoryPattern;

public class Client {
    public static void main(String[] args){
        Vehicle car = VehicleFactory.getVehicle("car");
        car.start();
        car.accelerate();
        car.brake();

        Vehicle bike = VehicleFactory.getVehicle("bike");
        bike.start();
        bike.accelerate();
        bike.brake();
    }
}

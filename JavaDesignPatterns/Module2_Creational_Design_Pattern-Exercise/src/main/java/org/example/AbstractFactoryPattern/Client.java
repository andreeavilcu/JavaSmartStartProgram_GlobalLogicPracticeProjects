package org.example.AbstractFactoryPattern;

import org.example.AbstractFactoryPattern.concreteFactories.AirVehicleFactory;
import org.example.AbstractFactoryPattern.concreteFactories.LandVehicleFactory;

public class Client {
    public static void main(String[] args){
        AbstractVehicleFactory landFactory = new LandVehicleFactory();
        AbstractVehicle car = landFactory.createCar();
        car.start();
        car.accelerate();

        AbstractVehicleFactory airFactory = new AirVehicleFactory();
        AbstractVehicle airPlane = airFactory.createAirplane();
        airPlane.start();
        airPlane.accelerate();
    }
}

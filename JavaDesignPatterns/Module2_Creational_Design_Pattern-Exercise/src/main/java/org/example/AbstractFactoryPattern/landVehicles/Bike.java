package org.example.AbstractFactoryPattern.landVehicles;

import org.example.AbstractFactoryPattern.AbstractVehicle;

public class Bike implements AbstractVehicle {
    public void start() { System.out.println("Bike started"); }
    public void accelerate() { System.out.println("Bike accelerating"); }
    public void brake() { System.out.println("Bike braking"); }
}

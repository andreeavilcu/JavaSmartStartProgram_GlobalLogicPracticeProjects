package org.example.AbstractFactoryPattern.landVehicles;

import org.example.AbstractFactoryPattern.AbstractVehicle;

public class Car implements AbstractVehicle {
    public void start() { System.out.println("Car started"); }
    public void accelerate() { System.out.println("Car accelerating"); }
    public void brake() { System.out.println("Car braking"); }
}


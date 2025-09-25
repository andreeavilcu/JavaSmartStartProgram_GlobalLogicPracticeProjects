package org.example.AbstractFactoryPattern.waterVehicles;

import org.example.AbstractFactoryPattern.AbstractVehicle;

public class Submarine implements AbstractVehicle {
    public void start() { System.out.println("Submarine started"); }
    public void accelerate() { System.out.println("Submarine diving"); }
    public void brake() { System.out.println("Submarine stopping"); }
}

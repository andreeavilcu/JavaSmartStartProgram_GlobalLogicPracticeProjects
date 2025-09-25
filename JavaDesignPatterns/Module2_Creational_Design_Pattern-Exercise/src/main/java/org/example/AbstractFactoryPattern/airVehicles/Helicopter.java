package org.example.AbstractFactoryPattern.airVehicles;

import org.example.AbstractFactoryPattern.AbstractVehicle;

public class Helicopter implements AbstractVehicle {
    public void start() { System.out.println("Helicopter started"); }
    public void accelerate() { System.out.println("Helicopter flying"); }
    public void brake() { System.out.println("Helicopter landing"); }
}

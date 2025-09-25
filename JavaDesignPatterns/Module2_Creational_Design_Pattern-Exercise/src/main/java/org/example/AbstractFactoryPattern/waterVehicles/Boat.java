package org.example.AbstractFactoryPattern.waterVehicles;

import org.example.AbstractFactoryPattern.AbstractVehicle;

public class Boat implements AbstractVehicle {
    public void start() { System.out.println("Boat started"); }
    public void accelerate() { System.out.println("Boat sailing"); }
    public void brake() { System.out.println("Boat stopped"); }
}

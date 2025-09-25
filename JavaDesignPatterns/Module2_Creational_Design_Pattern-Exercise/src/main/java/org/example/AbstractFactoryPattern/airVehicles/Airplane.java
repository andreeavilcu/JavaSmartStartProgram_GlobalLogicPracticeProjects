package org.example.AbstractFactoryPattern.airVehicles;

import org.example.AbstractFactoryPattern.AbstractVehicle;

public class Airplane implements AbstractVehicle {
    public void start() { System.out.println("Airplane started"); }
    public void accelerate() { System.out.println("Airplane taking off"); }
    public void brake() { System.out.println("Airplane landing"); }
}

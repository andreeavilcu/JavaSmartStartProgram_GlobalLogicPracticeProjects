package org.example.FactoryPattern;

public class Truck implements Vehicle {
    public void start() { System.out.println("Truck started"); }
    public void accelerate() { System.out.println("Truck accelerating"); }
    public void brake() { System.out.println("Truck braking"); }
}

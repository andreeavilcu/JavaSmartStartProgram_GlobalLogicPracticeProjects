package org.example.FactoryPattern;

public class Bike implements Vehicle {
    public void start() { System.out.println("Bike started"); }
    public void accelerate() { System.out.println("Bike accelerating"); }
    public void brake() { System.out.println("Bike braking"); }
}

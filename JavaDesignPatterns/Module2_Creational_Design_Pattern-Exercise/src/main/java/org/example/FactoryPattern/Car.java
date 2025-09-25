package org.example.FactoryPattern;

public class Car implements Vehicle {
    public void start() { System.out.println("Car started"); }
    public void accelerate() { System.out.println("Car accelerating"); }
    public void brake() { System.out.println("Car braking"); }
}

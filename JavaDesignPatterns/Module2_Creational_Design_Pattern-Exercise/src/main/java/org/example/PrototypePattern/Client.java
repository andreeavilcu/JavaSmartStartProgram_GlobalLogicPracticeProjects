package org.example.PrototypePattern;

public class Client {
    public static void main(String[] args){
        Shape circle1 = ShapeRegistry.getShape("circle");
        circle1.draw();

        Shape circle2 = ShapeRegistry.getShape("circle");
        circle2.draw();

        Shape rectangle = ShapeRegistry.getShape("rectangle");
        rectangle.draw();
    }
}

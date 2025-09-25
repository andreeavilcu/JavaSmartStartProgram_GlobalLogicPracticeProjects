package org.example.PrototypePattern;

import java.util.HashMap;
import java.util.Map;

public class ShapeRegistry {
    private static Map<String, Shape> registry = new HashMap<>();

    static{
        registry.put("circle", new Circle(10));
        registry.put("rectangle", new Rectangle(20, 30));
    }

    public static Shape getShape(String key) {
        return registry.get(key).clone();
    }
}

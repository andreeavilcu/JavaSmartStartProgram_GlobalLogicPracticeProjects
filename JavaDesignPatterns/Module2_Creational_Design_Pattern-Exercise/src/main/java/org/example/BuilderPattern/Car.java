package org.example.BuilderPattern;

public class Car {
    private String brand;
    private String model;
    private String color;
    private String engine;
    private String transmission;
    private String fuelType;

    private Car(CarBuilder builder) {
        this.brand = builder.brand;
        this.model = builder.model;
        this.color = builder.color;
        this.engine = builder.engine;
        this.transmission = builder.transmission;
        this.fuelType = builder.fuelType;
    }

    public static class CarBuilder {
        private String brand;
        private String model;
        private String color;
        private String engine;
        private String transmission;
        private String fuelType;

        public CarBuilder brand(String brand) { this.brand = brand; return this; }
        public CarBuilder model(String model) { this.model = model; return this; }
        public CarBuilder color(String color) { this.color = color; return this; }
        public CarBuilder engine(String engine) { this.engine = engine; return this; }
        public CarBuilder transmission(String transmission) { this.transmission = transmission; return this; }
        public CarBuilder fuelType(String fuelType) { this.fuelType = fuelType; return this; }

        public Car build() { return new Car(this); }
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", engine='" + engine + '\'' +
                ", transmission='" + transmission + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}


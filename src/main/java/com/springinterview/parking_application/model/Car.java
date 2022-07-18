package com.springinterview.parking_application.model;

public class Car extends Vehicle {
    private static final int size = 1;

    public Car(Vehicle vehicle) {
        this(vehicle, size);
    }

    public Car(Vehicle vehicle, int size){
        super(vehicle, size);

    }

    public int getSize() {
        return size;
    }
}

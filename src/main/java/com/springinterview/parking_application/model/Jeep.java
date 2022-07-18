package com.springinterview.parking_application.model;

public class Jeep extends Vehicle{
    private static final int size = 2;

    public Jeep(Vehicle vehicle) {
        this(vehicle, size);
    }

    public Jeep(Vehicle vehicle, int size){
        super(vehicle, size);

    }

    public int getSize() {
        return size;
    }
}

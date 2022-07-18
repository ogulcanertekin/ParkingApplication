package com.springinterview.parking_application.model;

import com.springinterview.parking_application.enums.VehicleType;

public class Truck extends Vehicle{
    private static final int size = 4;

    public Truck(Vehicle vehicle) {
        this(vehicle, size);
    }

    public Truck(Vehicle vehicle, int size){
        super(vehicle, size);
    }

    public int getSize() {
        return size;
    }
}

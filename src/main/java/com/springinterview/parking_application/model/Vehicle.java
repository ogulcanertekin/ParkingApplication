package com.springinterview.parking_application.model;

import com.springinterview.parking_application.enums.VehicleType;

public class Vehicle {
    private String plateNumber;
    private String vehicleColor;
    private VehicleType vehicleType;
    private int size;

    public Vehicle() {

    }

    public Vehicle(Vehicle vehicle, int size) {
        this.plateNumber = vehicle.getPlateNumber();
        this.vehicleColor = vehicle.getVehicleColor();
        this.vehicleType = vehicle.getVehicleType();
        this.size = size;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

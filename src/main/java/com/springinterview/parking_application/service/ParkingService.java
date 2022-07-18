package com.springinterview.parking_application.service;

import com.springinterview.parking_application.model.Vehicle;

public interface ParkingService {
    String parkVehicle(Vehicle vehicle);
    boolean leaveVehicle(int slotId);
    String getCurrentStatus();
}

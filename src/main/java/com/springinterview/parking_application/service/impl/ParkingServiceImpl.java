package com.springinterview.parking_application.service.impl;

import com.springinterview.parking_application.model.ParkArea;
import com.springinterview.parking_application.model.Vehicle;
import com.springinterview.parking_application.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingServiceImpl implements ParkingService {

    @Autowired
    private ParkArea<Vehicle> parkingArea;

    @Override
    public String parkVehicle(Vehicle vehicle) {
        return parkingArea.parkVehicle(vehicle);
    }

    @Override
    public boolean leaveVehicle(int vehicleOrderId) {
        return parkingArea.leaveVehicle(vehicleOrderId);
    }

    @Override
    public String getCurrentStatus() {
        return parkingArea.getParkingStatus();
    }
}

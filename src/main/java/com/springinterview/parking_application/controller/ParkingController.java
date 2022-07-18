package com.springinterview.parking_application.controller;

import com.springinterview.parking_application.model.Vehicle;
import com.springinterview.parking_application.model.factory.VehicleFactory;
import com.springinterview.parking_application.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking-service")
public class ParkingController {

    @Autowired
    private ParkingService parkingService;

    @Autowired
    private VehicleFactory vehicleFactory;

    @PostMapping("/park")
    String parkVehicle(@RequestBody Vehicle newVehicle) {
            Vehicle genericVehicle = vehicleFactory.createVehicle(newVehicle);
            return this.parkingService.parkVehicle(genericVehicle);
    }

    @DeleteMapping("/park/{vehicleOrderId}")
    boolean leaveVehicle(@PathVariable("vehicleOrderId") int vehicleOrderId) {
        return parkingService.leaveVehicle(vehicleOrderId);
    }

    @GetMapping("/status")
    String getParkingStatus() {
        return parkingService.getCurrentStatus();
    }

}
package com.springinterview.parking_application.model.factory;
import com.springinterview.parking_application.model.Car;
import com.springinterview.parking_application.model.Jeep;
import com.springinterview.parking_application.model.Truck;
import com.springinterview.parking_application.model.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleFactory {
    public Vehicle createVehicle(Vehicle vehicle){

        switch (vehicle.getVehicleType()) {
            case CAR:
                vehicle = new Car(vehicle);
                break;

            case JEEP:
                vehicle = new Jeep(vehicle);
                break;

            case TRUCK:
                vehicle = new Truck(vehicle);
                break;

            default:
                break;
        }
        return vehicle;
    }
}


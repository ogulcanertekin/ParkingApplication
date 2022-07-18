package com.springinterview.parking_application.model;

import com.springinterview.parking_application.model.ErrorConstants.NotificationConstants;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class ParkArea<T extends Vehicle> {

    private int parkCapacity;
    private int availableSlotCount;
    private AtomicReference<Set<String>> identicalTickets = new AtomicReference<>();
    private Map<Integer, String> parkingLots;
    private Map<Integer, Vehicle> vehicleOrderList;
    private int vehicleCount;

    public ParkArea() {
        this.parkCapacity = 10;
        this.availableSlotCount = 10;
        this.vehicleCount = 0;
        this.identicalTickets.set(new HashSet<>());
        this.parkingLots = new ConcurrentHashMap<>();
        this.vehicleOrderList = new ConcurrentHashMap<>();
        for (int slot = 1; slot <= parkCapacity; slot++) {
            this.addSlot(slot);
            this.parkingLots.put(slot, "");
        }
    }

    private final SortedSet<Integer> freeSlots = new TreeSet<>();

    public void addSlot(int slotNo) {
        freeSlots.add(slotNo);
    }


    public int getSlot() {
        return freeSlots.first();
    }

    public String parkVehicle(T vehicle) {
        if (identicalTickets.get().contains(vehicle.getPlateNumber())) {
            return NotificationConstants.ALREADY_EXIST;
        } else if (availableSlotCount < vehicle.getSize()) {
            return NotificationConstants.NOT_AVAILABLE;
        }
        int availableSlot = this.getSlot();
        availableSlotCount = availableSlotCount - vehicle.getSize();
        for(int i = availableSlot; i<availableSlot+vehicle.getSize(); i++ ){
            parkingLots.put(i, vehicle.getPlateNumber() + vehicle.getVehicleColor());
        }
        vehicleCount = vehicleCount + 1;
        vehicleOrderList.put(vehicleCount, vehicle);
        identicalTickets.get().add(vehicle.getPlateNumber());

        return String.format(NotificationConstants.PARK_SUCCESSFUL,vehicle.getSize());

    }

    public boolean leaveVehicle(int vehicleOrderId) {
        if(vehicleOrderId>vehicleOrderList.size()){
            return false;
        }else {
            vehicleCount = vehicleCount -1;
            availableSlotCount = availableSlotCount - vehicleOrderList.get(vehicleOrderId).getSize();
            vehicleOrderList.remove(vehicleOrderId);
            return true;
        }
    }

    public String getParkingStatus() {
        List<String> statusTextList = new ArrayList<String>();
        for (Map.Entry<Integer, Vehicle> entry : vehicleOrderList.entrySet()) {
            String statusLineText = entry.getValue().getPlateNumber()+ " " + entry.getValue().getVehicleColor();
            int totalSlotsOfVehicle = entry.getValue().getSize();
            for(int i=1 ; i <= totalSlotsOfVehicle; i++){
                statusLineText = statusLineText.concat("," + String.valueOf(i));
            }
            statusTextList.add(statusLineText);
        }
        return StringUtils.join(statusTextList, '\n');
    }

}

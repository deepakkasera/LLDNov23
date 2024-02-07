package org.example.ParkingLot.strategies;

import org.example.ParkingLot.models.Gate;
import org.example.ParkingLot.models.ParkingSpot;
import org.example.ParkingLot.models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(Gate gate, VehicleType vehicleType);
}

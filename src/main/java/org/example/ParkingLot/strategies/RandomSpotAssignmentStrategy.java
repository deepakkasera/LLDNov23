package org.example.ParkingLot.strategies;

import org.example.ParkingLot.models.*;
import org.example.ParkingLot.repositories.ParkingLotRepository;

import java.util.Optional;
import java.util.Random;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {
    private ParkingLotRepository parkingLotRepository;

    public RandomSpotAssignmentStrategy(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public ParkingSpot assignSpot(Gate gate, VehicleType vehicleType) {
        //findParkingLotByGateId
        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.findByGateId(gate.getId());
        ParkingLot parkingLot = null;
        if (optionalParkingLot.isPresent()) {
            parkingLot = optionalParkingLot.get();
        } else {
            //TODO
            //throw ParkingLotNotFoundException.
        }

        for (ParkingFloor parkingFloor : parkingLot.getParkingFloors()) { // 5 to 10
            for (ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
                if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY)
                && parkingSpot.getVehicleTypes().contains(vehicleType)) {
                    return parkingSpot;
                }
            }
        }
        return null;
    }
}

/*

ParkingLot -> Table
id, gateId,

 */
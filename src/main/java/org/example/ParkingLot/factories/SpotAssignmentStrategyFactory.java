package org.example.ParkingLot.factories;

import org.example.ParkingLot.models.SpotAssigmentStrategyType;
import org.example.ParkingLot.repositories.ParkingLotRepository;
import org.example.ParkingLot.strategies.CheapestSpotAssignmentStrategy;
import org.example.ParkingLot.strategies.RandomSpotAssignmentStrategy;
import org.example.ParkingLot.strategies.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {
    //This is the factory to create the right Strategy for the user.

    public static SpotAssignmentStrategy getSpotAssignmentStrategy(
            SpotAssigmentStrategyType spotAssigmentStrategyType, ParkingLotRepository parkingLotRepository) {
        if (spotAssigmentStrategyType.equals(SpotAssigmentStrategyType.RANDOM)) {
            return new RandomSpotAssignmentStrategy(parkingLotRepository);
        } else if (spotAssigmentStrategyType.equals(SpotAssigmentStrategyType.CHEAPEST)) {
            return new CheapestSpotAssignmentStrategy();
        }
        return null;
    }
}

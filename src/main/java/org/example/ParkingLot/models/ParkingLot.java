package org.example.ParkingLot.models;

import java.util.List;

public class ParkingLot extends BaseModel {
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private ParkingLotStatus parkingLotStatus;
    private List<VehicleType> vehicleTypes;
    private FeeCalculationStrategyType feeCalculationStrategyType;
    private SpotAssigmentStrategyType spotAssigmentStrategyType;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public FeeCalculationStrategyType getFeeCalculationStrategyType() {
        return feeCalculationStrategyType;
    }

    public void setFeeCalculationStrategyType(FeeCalculationStrategyType feeCalculationStrategyType) {
        this.feeCalculationStrategyType = feeCalculationStrategyType;
    }

    public SpotAssigmentStrategyType getSpotAssigmentStrategyType() {
        return spotAssigmentStrategyType;
    }

    public void setSpotAssigmentStrategyType(SpotAssigmentStrategyType spotAssigmentStrategyType) {
        this.spotAssigmentStrategyType = spotAssigmentStrategyType;
    }
}

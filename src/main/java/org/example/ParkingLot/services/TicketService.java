package org.example.ParkingLot.services;

import org.example.ParkingLot.exceptions.GateNotFoundException;
import org.example.ParkingLot.factories.SpotAssignmentStrategyFactory;
import org.example.ParkingLot.models.*;
import org.example.ParkingLot.repositories.GateRepository;
import org.example.ParkingLot.repositories.ParkingLotRepository;
import org.example.ParkingLot.repositories.TicketRepository;
import org.example.ParkingLot.repositories.VehicleRepository;
import org.example.ParkingLot.strategies.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;
import java.util.Random;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository,
                         ParkingLotRepository parkingLotRepository, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(Long gateId, String ownerName, VehicleType vehicleType, String vehicleNumber) throws GateNotFoundException {
        //generate ticket logic
        //1. Fetch the gate object from Database.
        //2. Fetch the Vehicle details from the Database.
        //3. Validate the user details.
        //4. Finally book the ticket.

        Optional<Gate> optionalGate = gateRepository.findGateById(gateId);
        Gate gate = null;
        Operator operator = null;
        Vehicle vehicle = null;
        if (optionalGate.isPresent()) {
            gate = optionalGate.get();
            operator = optionalGate.get().getCurrentOperator();
        } else {
            throw new GateNotFoundException("Invalid gate id");
        }

        Optional<Vehicle> optionalVehicle = vehicleRepository.findVehicleByNumber(vehicleNumber);
        if (optionalVehicle.isPresent()) {
            vehicle = optionalVehicle.get();
        } else {
            vehicle = new Vehicle();
            vehicle.setVehicleNumber(vehicleNumber);
            vehicle.setOwnerName(ownerName);
            vehicle.setVehicleType(vehicleType);
            vehicle = vehicleRepository.save(vehicle);
        }

        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentStrategyFactory.getSpotAssignmentStrategy(
                SpotAssigmentStrategyType.RANDOM, parkingLotRepository
        );
        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(gate, vehicleType);

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date()); //current Time
        ticket.setNumber(String.valueOf(new Random().nextInt()));
        ticket.setVehicle(vehicle);
        ticket.setGeneratedBy(operator);
        ticket.setParkingSpot(parkingSpot);
        ticket.setGeneratedAt(gate);
        ticket = ticketRepository.save(ticket);
        return ticket;
    }
}

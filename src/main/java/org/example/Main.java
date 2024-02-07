package org.example;

import org.example.ParkingLot.controllers.TicketController;
import org.example.ParkingLot.dtos.IssueTicketRequestDto;
import org.example.ParkingLot.dtos.IssueTicketResponseDto;
import org.example.ParkingLot.dtos.ResponseStatus;
import org.example.ParkingLot.models.Gate;
import org.example.ParkingLot.models.Ticket;
import org.example.ParkingLot.models.VehicleType;
import org.example.ParkingLot.repositories.GateRepository;
import org.example.ParkingLot.repositories.ParkingLotRepository;
import org.example.ParkingLot.repositories.TicketRepository;
import org.example.ParkingLot.repositories.VehicleRepository;
import org.example.ParkingLot.services.TicketService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        GateRepository gateRepository = new GateRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        TicketRepository ticketRepository = new TicketRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        TicketService ticketService = new TicketService(gateRepository,
                vehicleRepository,
                parkingLotRepository,
                ticketRepository);

        TicketController ticketController = new TicketController(ticketService);

        IssueTicketRequestDto requestDto = new IssueTicketRequestDto();
        requestDto.setGateId(123L);
        requestDto.setVehicleNumber("HR16X1234");
        requestDto.setVehicleOwnerName("Deepak");
        requestDto.setVehicleType(VehicleType.SUV);


        //TODO : Enter some random data in the maps and check if we are able to create a ticket object or not.

        Ticket ticket = null;
        IssueTicketResponseDto responseDto = ticketController.issueTicket(requestDto);
        if (responseDto.getResponseStatus().equals(ResponseStatus.SUCCESS)) {
            ticket = responseDto.getTicket();
        } else {
            System.out.println("Issue Ticket method failed for some reason.");
        }
    }
}


//TicketController -> TicketService
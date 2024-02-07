package org.example.ParkingLot.repositories;

import org.example.ParkingLot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private Map<Long, Ticket> ticketMap = new HashMap<>();
    private Long ticketId;

    public Ticket save(Ticket ticket) {
        ticketId++;
        ticket.setId(ticketId);
        ticketMap.put(ticketId, ticket);
        return ticket;
    }
}

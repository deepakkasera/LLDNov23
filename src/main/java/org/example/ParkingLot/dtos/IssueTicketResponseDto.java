package org.example.ParkingLot.dtos;

import org.example.ParkingLot.models.Ticket;

public class IssueTicketResponseDto {
    private ResponseStatus responseStatus;
    private Ticket ticket;

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}


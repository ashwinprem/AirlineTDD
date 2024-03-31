package com.ontariotechu.sofe3980U;

import java.util.Objects;

public class Ticket {
    private final String ticketNumber;
    private final Flight flight;
    private final Passenger passenger;

    public Ticket(String ticketNumber, Flight flight, Passenger passenger) {
        this.ticketNumber = Objects.requireNonNull(ticketNumber, "Ticket number cannot be null");
        this.flight = Objects.requireNonNull(flight, "Flight cannot be null");
        this.passenger = Objects.requireNonNull(passenger, "Passenger cannot be null");
    }

    // Getters
    public String getTicketNumber() {
        return ticketNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    // Equality and hashing
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(ticketNumber, ticket.ticketNumber) &&
                Objects.equals(flight, ticket.flight) &&
                Objects.equals(passenger, ticket.passenger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketNumber, flight, passenger);
    }

    // toString method
    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber='" + ticketNumber + '\'' +
                ", flight=" + flight +
                ", passenger=" + passenger +
                '}';
    }
}

/* Justin
package com.ontariotechu.sofe3980U;

public class Ticket {
    private String ticketNumber;
    private Flight flight;
    private Passenger passenger;

    public Ticket(String ticketNumber, Flight flight, Passenger passenger) {
        this.ticketNumber = ticketNumber;
        this.flight = flight;
        this.passenger = passenger;
    }

    public String getTicketNumber() {
        return ticketNumber;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    // Setters
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}


 */
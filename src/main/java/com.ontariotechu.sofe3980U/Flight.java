package com.ontariotechu.sofe3980U;

import java.time.ZoneId;
import java.util.Objects;

public class Flight {
    private Long id; // Optional: useful if you're persisting flights or referencing them uniquely
    private String flightNumber;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private String departureTime; // Time as String; consider using LocalTime for time operations
    private String arrivalTime;   // Time as String; consider using LocalTime for time operations
    private int flightDuration; // Duration in hours, consider using Duration for time operations
    // Removed timezone fields since timezones are part of City, which is part of Airport

    public Flight(String flightNumber, Airport departureAirport, Airport arrivalAirport,
                  String departureTime, String arrivalTime, int flightDuration) {
        this.flightNumber = Objects.requireNonNull(flightNumber, "Flight number cannot be null");
        this.departureAirport = Objects.requireNonNull(departureAirport, "Departure airport cannot be null");
        this.arrivalAirport = Objects.requireNonNull(arrivalAirport, "Arrival airport cannot be null");
        if (departureAirport.equals(arrivalAirport)) {
            throw new IllegalArgumentException("Departure and arrival airports cannot be the same");
        }
        this.departureTime = departureTime; // Consider validating format
        this.arrivalTime = arrivalTime;     // Consider validating format
        this.flightDuration = flightDuration;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    // The rest of the getters and setters...

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getFlightDuration() {
        return flightDuration;
    }

    public void setFlightDuration(int flightDuration) {
        this.flightDuration = flightDuration;
    }



    // Consider adding toString, equals, and hashCode methods for better debugging and object comparison
}

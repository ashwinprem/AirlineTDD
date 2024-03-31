package com.ontariotechu.sofe3980U;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Booking {
    private Long id; // Added id field
    private String bookingNumber;
    private List<Flight> flights;
    private List<Passenger> passengers;
    private boolean isRoundTrip;
    private boolean isDirectFlight;
    private ZoneId userTimezone;

    // Constructor
    public Booking(String bookingNumber, List<Flight> flights, List<Passenger> passengers,
                   boolean isRoundTrip, boolean isDirectFlight, ZoneId userTimezone) {
        this.bookingNumber = Objects.requireNonNull(bookingNumber, "Booking number cannot be null");
        this.flights = flights != null ? new ArrayList<>(flights) : new ArrayList<>();
        this.passengers = passengers != null ? new ArrayList<>(passengers) : new ArrayList<>();
        this.isRoundTrip = isRoundTrip;
        this.isDirectFlight = isDirectFlight;
        this.userTimezone = Objects.requireNonNull(userTimezone, "User timezone cannot be null");
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getters and setters
    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public List<Flight> getFlights() {
        return Collections.unmodifiableList(flights);
    }

    public void setFlights(List<Flight> flights) {
        this.flights = new ArrayList<>(flights);
    }

    public List<Passenger> getPassengers() {
        return Collections.unmodifiableList(passengers);
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = new ArrayList<>(passengers);
    }

    public boolean isRoundTrip() {
        return isRoundTrip;
    }

    public void setRoundTrip(boolean roundTrip) {
        isRoundTrip = roundTrip;
    }

    public boolean isDirectFlight() {
        return isDirectFlight;
    }

    public void setDirectFlight(boolean directFlight) {
        isDirectFlight = directFlight;
    }

    public ZoneId getUserTimezone() {
        return userTimezone;
    }

    public void setUserTimezone(ZoneId userTimezone) {
        this.userTimezone = userTimezone;
    }

    // Methods to add a flight or passenger to their respective lists
    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }
}

package com.ontariotechu.sofe3980U;

import java.time.ZoneId;
import java.util.List;

public class BookingForm {
    private String bookingNumber;
    private List<Long> flightIds; // Assuming the form collects flight IDs
    private List<String> passengerNames; // Simplified example
    private boolean isRoundTrip;
    private boolean isDirectFlight;
    private ZoneId userTimezone;
    // Getters and setters
    public String getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(String bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public List<Long> getFlightIds() {
        return flightIds;
    }

    public void setFlightIds(List<Long> flightIds) {
        this.flightIds = flightIds;
    }

    public List<String> getPassengerNames() {
        return passengerNames;
    }

    public void setPassengerNames(List<String> passengerNames) {
        this.passengerNames = passengerNames;
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

    // Add constructors, validation annotations, etc., as needed.
}

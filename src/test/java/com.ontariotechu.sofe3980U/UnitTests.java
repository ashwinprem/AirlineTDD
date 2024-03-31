package com.ontariotechu.sofe3980U;

import org.junit.Test;
import static org.junit.Assert.*;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class UnitTests {

    @Test
    public void testBookingConstruction() {
        ZoneId timezone = ZoneId.of("GMT");
        List<Flight> flights = new ArrayList<>();
        List<Passenger> passengers = new ArrayList<>();
        Booking booking = new Booking("123456", flights, passengers, true, true, timezone);
        assertEquals("123456", booking.getBookingNumber());
        assertTrue(booking.isRoundTrip());
        assertTrue(booking.isDirectFlight());
        assertEquals(timezone, booking.getUserTimezone());
    }

    @Test
    public void testTimezoneConversion() {
        ZoneId sourceZone = ZoneId.of("America/New_York"); // Assuming EST
        ZoneId targetZone = ZoneId.of("America/Los_Angeles"); // Assuming PST
        String result = new TimeConverter().convertTime("10:00", sourceZone, targetZone);
        assertEquals("07:00", result); // Example; actual result depends on DST.
    }

    @Test
    public void testCountryConstruction() {
        Country country = new Country("US", "United States");
        assertEquals("US", country.getCode());
        assertEquals("United States", country.getName());
    }

    @Test
    public void testFlightConstruction() {
        ZoneId timezoneEST = ZoneId.of("America/New_York");
        ZoneId timezonePST = ZoneId.of("America/Los_Angeles");
        Country country = new Country("US", "United States");
        City newYork = new City("New York", timezoneEST, country);
        City losAngeles = new City("Los Angeles", timezonePST, country);
        Airport departureAirport = new Airport("JFK", newYork, new ArrayList<>());
        Airport arrivalAirport = new Airport("LAX", losAngeles, new ArrayList<>());
        Flight flight = new Flight("123", departureAirport, arrivalAirport, "10:00", "13:00", 180);

        assertEquals("123", flight.getFlightNumber());
        assertEquals(departureAirport, flight.getDepartureAirport());
        assertEquals(arrivalAirport, flight.getArrivalAirport());
        assertEquals("10:00", flight.getDepartureTime());
        assertEquals("13:00", flight.getArrivalTime());
        assertEquals(180, flight.getFlightDuration());
    }

    @Test
    public void testUserConstruction() {
        Preferences preferences = new Preferences(true);
        User user = new User("john_doe", "password123", preferences);
        assertEquals("john_doe", user.getUsername());
        assertEquals("password123", user.getPassword());
        assertTrue(user.getPreferences().isUsing12HourFormat());
    }

    @Test
    public void testPreferencesConstruction() {
        Preferences preferences = new Preferences(true);
        assertTrue(preferences.isUsing12HourFormat());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCyclicTrip() {
        ZoneId timezone = ZoneId.of("America/New_York");
        Country country = new Country("US", "United States");
        City newYork = new City("New York", timezone, country);
        Airport airport = new Airport("JFK", newYork, new ArrayList<>());
        new Flight("123", airport, airport, "10:00", "13:00", 180); // This should throw an IllegalArgumentException
    }

    @Test
    public void test24HourTimeTo12HourConversion() {
        TimeConverter timeConverter = new TimeConverter();
        String convertedTime = timeConverter.convert24HourTimeTo12Hour("19:00");
        assertEquals("7:00 PM", convertedTime);
    }

    @Test
    public void test12HourTimeTo24HourConversion() {
        TimeConverter timeConverter = new TimeConverter();
        String convertedTime = timeConverter.convert12HourTimeTo24Hour("7:00 PM");
        assertEquals("19:00", convertedTime);
    }

    // Note: Mocking tests for TimeConverter removed since actual implementation is straightforward and doesn't involve external dependencies.
}

package com.ontariotechu.sofe3980U;

import org.springframework.stereotype.Service;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    private final List<Flight> flights = new ArrayList<>();

    public FlightService() {
        // Setup for countries, assuming you have a similar setup
        Country usa = new Country("US", "United States");

        // Setting up cities with their ZoneId and associated country
        City newYork = new City("New York", ZoneId.of("America/New_York"), usa);
        City losAngeles = new City("Los Angeles", ZoneId.of("America/Los_Angeles"), usa);
        City chicago = new City("Chicago", ZoneId.of("America/Chicago"), usa);
        City miami = new City("Miami", ZoneId.of("America/New_York"), usa);

        // Creating airports with their codes and associated cities
        Airport jfkAirport = new Airport("JFK", newYork, new ArrayList<>());
        Airport laxAirport = new Airport("LAX", losAngeles, new ArrayList<>());
        Airport ordAirport = new Airport("ORD", chicago, new ArrayList<>());
        Airport miaAirport = new Airport("MIA", miami, new ArrayList<>());

        // Assuming the Flight constructor accepts Strings for departure/arrival times,
        // integers for flight duration, and does not require a list of flights in its constructor
        flights.add(new Flight("FL123", jfkAirport, laxAirport, "08:00", "11:00", 5, newYork.getTimezone(), losAngeles.getTimezone()));
        flights.add(new Flight("FL456", ordAirport, miaAirport, "09:00", "12:30", 3, chicago.getTimezone(), miami.getTimezone()));
    }

    public List<Flight> findAllFlights() {
        return new ArrayList<>(flights);
    }


    public Flight findFlightById(Long id) {
        return flights.stream()
                .filter(flight -> flight.getId() != null && flight.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}

package com.ontariotechu.sofe3980U;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class Airport {
    private String airportCode;
    private City city;
    private List<Flight> flightList; // Use List interface and follow Java naming conventions

    public Airport(String airportCode, City city, List<Flight> flightList) {
        this.airportCode = Objects.requireNonNull(airportCode, "Airport code cannot be null");
        this.city = Objects.requireNonNull(city, "City cannot be null");
        this.flightList = (flightList == null) ? new ArrayList<>() : new ArrayList<>(flightList);
    }

    // Getters and Setters
    public List<Flight> getFlights(){
        return flightList;
    }

    public String getCode(){
        return airportCode;
    }

    public void setCode(String code){
        this.airportCode = code;
    }

    public City getCity(){
        return city;
    }

    public void setCity(City city){
        this.city = city;
    }

    public void addFlight(Flight flight){
        flightList.add(flight);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "code='" + airportCode + '\'' +
                ", city=" + city +
                ", number of flights=" + flightList.size() +
                '}';
    }
}

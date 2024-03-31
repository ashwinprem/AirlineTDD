package com.ontariotechu.sofe3980U;

import java.time.ZoneId;
import java.util.Objects;

public class City {
    private String name;
    private ZoneId timezone; // Use ZoneId instead of TimeZone
    private Country country;

    public City(String name, ZoneId timezone, Country country) {
        this.name = validateName(name);
        this.timezone = validateTimezone(timezone);
        this.country = validateCountry(country);
    }

    // Validation methods to prevent null values
    private String validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("City name cannot be null or empty");
        }
        return name;
    }

    private ZoneId validateTimezone(ZoneId timezone) {
        if (timezone == null) {
            throw new IllegalArgumentException("Timezone cannot be null");
        }
        return timezone;
    }

    private Country validateCountry(Country country) {
        if (country == null) {
            throw new IllegalArgumentException("Country cannot be null");
        }
        return country;
    }

    // Getters
    public String getName() {
        return name;
    }

    public ZoneId getTimezone() {
        return timezone;
    }

    public Country getCountry() {
        return country;
    }

    // Setters
    public void setName(String name) {
        this.name = validateName(name);
    }

    public void setTimezone(ZoneId timezone) {
        this.timezone = validateTimezone(timezone);
    }

    public void setCountry(Country country) {
        this.country = validateCountry(country);
    }
}


/* justin
public class City {
    String name;
    Timezone timezone;
    Country country;

    public City(String name, Timezone timezone, Country country){
        this.name=name;
        this.timezone=timezone;
        this.country=country;
    }
}

 */

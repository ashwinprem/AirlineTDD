package com.ontariotechu.sofe3980U;

public class Country {
    private String code; // ISO 3166-1 alpha-2 country code
    private String name;

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    // Getters
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    // Setters
    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Override toString, equals, and hashCode methods as needed
}

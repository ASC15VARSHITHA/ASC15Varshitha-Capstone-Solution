package org.example.model;

public class AirportDTO {
    private String airportId;
    private String airportName;
    private String countryCode;

    public AirportDTO(String airportId, String airportName, String countryCode) {
        this.airportId = airportId;
        this.airportName = airportName;
        this.countryCode = countryCode;
    }

    // Getters and Setters
    public String getAirportId() {
        return airportId;
    }

    public void setAirportId(String airportId) {
        this.airportId = airportId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}

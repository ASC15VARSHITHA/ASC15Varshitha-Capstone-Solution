package org.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airports")
public class AirportEntity {
    @Id
    @Column(name = "airport_id")
    private String airportId;
    @Column(name = "airport_name", nullable = false)
    private String airportName;
    @Column(name = "country_code")
    private String countryCode;

    //Default Constructor
    public AirportEntity() {}

    // Constructor
    public AirportEntity(String  airportId, String airportName, String countryCode) {
        this.airportId = airportId;
        this.airportName =airportName;
        this.countryCode = countryCode;
    }

    // Getters and Setters
    public String getAirportId() {
        return airportId;
    }

    public void setAirportId(String airportId) {
        this.airportId = airportId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    @Override
    public String toString() {
        return "AirportEntity{" +
                "airportId='" + airportId + '\'' +
                ", airportName='" + airportName + '\'' +
                ", countryCode='" + countryCode + '\'' +
                '}';
    }
}

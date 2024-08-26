package org.example.service;

import org.example.entity.AirportEntity;
import org.example.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;

    public String substringAirportId() {
        Long airportIdCount = airportRepository.count() + 1;
        return String.format("A%04d", airportIdCount);
    }

    //CRUD - CREATE
    public AirportEntity createAirport(AirportEntity airportEntity) {
        airportEntity.setAirportId(substringAirportId());
        return airportRepository.save(airportEntity);
    }

    // CRUD - READ
    public List<AirportEntity> getAllAirports() {
        return airportRepository.findAll();
    }

    //SEARCH BY ID
    public AirportEntity getAirportById(String airportId) {
        return airportRepository.findById(airportId).orElseThrow(()-> new RuntimeException("Airport id not found"));
    }

    // CRUD-UPDATE
    public AirportEntity updateAirport(String airportId, AirportEntity airportEntity) {
        if (airportRepository.existsById(airportId)) {
            airportEntity.setAirportId(airportId);
            return airportRepository.save(airportEntity);
        }
        return null;
    }

    //CRUD-DELETE
    public void deleteAirport(String airportId) {
        airportRepository.deleteById(airportId);
    }
}

package org.example.controller;

import org.example.entity.AirportEntity;
import org.example.model.AirportDTO;
import org.example.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/airports")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @PostMapping("/create")
    public AirportDTO createAirport(@RequestBody AirportDTO airportDTO) {
        AirportEntity airportEntity = new AirportEntity(null, airportDTO.getAirportName(), airportDTO.getCountryCode());
        AirportEntity entity = airportService.createAirport(airportEntity);
        return new AirportDTO(entity.getAirportId(), entity.getAirportName(), entity.getCountryCode());
    }

    @GetMapping("/allairports")
    public List<AirportDTO> getAllAirports() {
        return airportService.getAllAirports().stream().map(airportEntity -> new AirportDTO(airportEntity.getAirportId(), airportEntity.getAirportName(), airportEntity.getCountryCode())).collect(Collectors.toList());
    }

//
    @GetMapping("/search/{airportId}")
    public  AirportDTO getAirportById(@PathVariable String airportId) {
        AirportEntity airportEntity = airportService.getAirportById(airportId);
        return new AirportDTO(airportEntity.getAirportId(), airportEntity.getAirportName(), airportEntity.getCountryCode());
    }

    @PutMapping("/update/{airportId}")
    public AirportDTO updateAirport(@PathVariable String airportId, @RequestBody AirportDTO airportDTO) {
        AirportEntity airportEntity = new AirportEntity(airportId, airportDTO.getAirportName(), airportDTO.getCountryCode());
        AirportEntity updatedEntity = airportService.updateAirport(airportId, airportEntity);
        return new AirportDTO(updatedEntity.getAirportId(), updatedEntity.getAirportName(), updatedEntity.getCountryCode());
    }

    @DeleteMapping("/delete/{airportId}")
    public void deleteAirport(@PathVariable String airportId) {
        airportService.deleteAirport(airportId);
    }
}

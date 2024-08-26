package org.example.service;

import org.example.entity.PlaneEntity;
import org.example.model.PlaneDTO;
import org.example.repository.PlaneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaneService {
    @Autowired
    private PlaneRepository planeRepository;

    // plane id substring auto-generated method
    private String substringPlaneId() {
        Integer planeCount = planeRepository.findAll().size() + 1;
        return String.format("P%04d", planeCount);
    }


    // CRUD - CREATE
    public PlaneDTO createPlane(PlaneDTO planeDTO) {

        if (planeDTO.getPlaneCapacity() <= 0) {
            throw new IllegalArgumentException("Add Positive Plane Capacity!");
        }

        PlaneEntity planeEntity = new PlaneEntity();
        planeEntity.setPlaneId(substringPlaneId());
        planeEntity.setPlaneCapacity(planeDTO.getPlaneCapacity());
        planeEntity.setPlaneCategory(planeDTO.getPlaneCategory());
        planeEntity.setPlaneModel(planeDTO.getPlaneModel());
        planeEntity.setPlaneOperator(planeDTO.getPlaneOperator());
        planeRepository.save(planeEntity);
        planeDTO.setPlaneId(planeEntity.getPlaneId());
        return planeDTO;
    }

    //CRUD - UPDATE
    public PlaneDTO updatePlane(String planeId, PlaneDTO planeDTO) {

        PlaneEntity planeEntity = planeRepository.findById(planeId).orElseThrow(() -> new RuntimeException("Plane not found"));

        planeEntity.setPlaneCapacity(planeDTO.getPlaneCapacity());
        planeEntity.setPlaneCategory(planeDTO.getPlaneCategory());
        planeEntity.setPlaneModel(planeDTO.getPlaneModel());
        planeEntity.setPlaneOperator(planeDTO.getPlaneOperator());
        planeRepository.save(planeEntity);
        return planeDTO;
    }

    // SEARCH BY ID
    public PlaneDTO getPlaneById(String planeId) {
        PlaneEntity planeEntity = planeRepository.findById(planeId).orElseThrow(() -> new RuntimeException("Plane not found"));
        PlaneDTO planeDTO = new PlaneDTO();
        planeDTO.setPlaneId(planeEntity.getPlaneId());
        planeDTO.setPlaneCapacity(planeEntity.getPlaneCapacity());
        planeDTO.setPlaneCategory(planeEntity.getPlaneCategory());
        planeDTO.setPlaneModel(planeEntity.getPlaneModel());
        planeDTO.setPlaneOperator(planeEntity.getPlaneOperator());
        return planeDTO;
    }

    // CRUD - READ
    public List<PlaneDTO> getAllPlanes() {
        List<PlaneEntity> planeEntityList = planeRepository.findAll();
        List<PlaneDTO> planeDTOList = new ArrayList<>();

        for (PlaneEntity planeEntity : planeEntityList) {
            PlaneDTO planeDTO = new PlaneDTO();
            planeDTO.setPlaneId(planeEntity.getPlaneId());
            planeDTO.setPlaneCapacity(planeEntity.getPlaneCapacity());
            planeDTO.setPlaneCategory(planeEntity.getPlaneCategory());
            planeDTO.setPlaneModel(planeEntity.getPlaneModel());
            planeDTO.setPlaneOperator(planeEntity.getPlaneOperator());
            planeDTOList.add(planeDTO);
        }
            return planeDTOList;

    }

    // CRUD - DELETE
    public void deletePlane(String planeId) {
        planeRepository.deleteById(planeId);
    }
}

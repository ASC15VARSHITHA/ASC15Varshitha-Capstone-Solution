package org.example.controller;

import org.example.model.PlaneDTO;
import org.example.service.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/image/planes")
public class PlaneController {

    @Autowired
    private PlaneService planeService;

    @PostMapping("/create")
    public PlaneDTO createPlane(@RequestBody PlaneDTO planeDTO) {
        return planeService.createPlane(planeDTO);
    }

    @PutMapping("/update/{planeId}")
    public PlaneDTO updatePlane(@PathVariable String planeId, @RequestBody PlaneDTO planeDTO) {
        return planeService.updatePlane(planeId, planeDTO);
    }

    @GetMapping("/{planeId}")
    public PlaneDTO getPlaneById(@PathVariable String planeId) {
        return planeService.getPlaneById(planeId);
    }

    @GetMapping("/allplanes")
    public List<PlaneDTO> getAllPlanes() {
        return planeService.getAllPlanes();
    }

    @DeleteMapping("/delete/{planeId}")
    public void deletePlane(@PathVariable String planeId) {
        planeService.deletePlane(planeId);
    }
}

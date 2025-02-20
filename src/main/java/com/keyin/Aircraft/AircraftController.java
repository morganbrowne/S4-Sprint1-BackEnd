package com.keyin.Aircraft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AircraftController {
    @Autowired
    private AircraftService aircraftService;

    @GetMapping("/aircrafts")
    public List<Aircraft> getAircrafts() {
        return aircraftService.findAllAircrafts();
    }

    @GetMapping("/aircrafts/{id}")
    public Aircraft getAircraftById(@PathVariable long id) {
        return aircraftService.findAircraftById(id);
    }

    @PostMapping("/aircrafts")
    public Aircraft addAircraft(@RequestBody Aircraft newAircraft) {
        return aircraftService.createAircraft(newAircraft);
    }

    @PutMapping("/aircrafts/{id}")
    public Aircraft updateAircraft(@PathVariable long id, @RequestBody Aircraft updatedAircraft) {
        return aircraftService.updateAircraft(id, updatedAircraft);
    }
}


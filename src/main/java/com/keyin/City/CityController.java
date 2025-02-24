package com.keyin.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cities")  // Base URL for this controller
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }


    @GetMapping
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }


    @GetMapping("/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {
        Optional<City> city = cityService.getCityById(id);
        return city.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<City> addCity(@RequestBody City city) {
        City createdCity = cityService.addCity(city);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCity);
    }


    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City cityDetails) {
        City updatedCity = cityService.updateCity(id, cityDetails);
        return ResponseEntity.ok(updatedCity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return ResponseEntity.noContent().build();
    }
}

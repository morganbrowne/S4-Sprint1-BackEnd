package com.keyin.Passenger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passengers")
public class PassengerController {
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    public List<Passenger> getAllPassengers() {
        return passengerService.getAllPassengers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getPassengerById(@PathVariable Long id) {
        Passenger passenger = passengerService.getPassengerById(id);
        return (passenger != null) ? ResponseEntity.ok(passenger) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Passenger addPassenger(@RequestBody Passenger passenger) {
        return passengerService.addPassenger(passenger);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable Long id, @RequestBody Passenger passengerDetails) {
        Passenger updatedPassenger = passengerService.updatePassenger(id, passengerDetails);
        return (updatedPassenger != null) ? ResponseEntity.ok(updatedPassenger) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id) {
        passengerService.deletePassenger(id);
        return ResponseEntity.noContent().build();
    }
}
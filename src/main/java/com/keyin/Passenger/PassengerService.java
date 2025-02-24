package com.keyin.Passenger;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {
    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    public Passenger getPassengerById(Long id) {
        return passengerRepository.findById(id).orElse(null);
    }

    public Passenger addPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    public Passenger updatePassenger(Long id, Passenger passengerDetails) {
        Optional<Passenger> existingPassenger = passengerRepository.findById(id);

        if (existingPassenger.isPresent()) {
            Passenger passenger = existingPassenger.get();
            passenger.setFirstName(passengerDetails.getFirstName());
            passenger.setLastName(passengerDetails.getLastName());
            passenger.setPhoneNumber(passengerDetails.getPhoneNumber());
            passenger.setCity(passengerDetails.getCity());
            passenger.setAircraftList(passengerDetails.getAircraftList());
            return passengerRepository.save(passenger);
        } else {
            return null;
        }
    }

    public void deletePassenger(Long id) {
        passengerRepository.deleteById(id);
    }
}

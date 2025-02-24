package com.keyin.City;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }


    public List<City> getAllCities() {
        return cityRepository.findAll();
    }


    public Optional<City> getCityById(Long id) {
        return cityRepository.findById(id);
    }


    public City addCity(City city) {
        return cityRepository.save(city);
    }

    // Update an existing city
    public City updateCity(Long id, City cityDetails) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));

        city.setName(cityDetails.getName());
        city.setProvince(cityDetails.getProvince());
        city.setPopulation(cityDetails.getPopulation());

        return cityRepository.save(city);
    }

    // Delete a city
    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }
}
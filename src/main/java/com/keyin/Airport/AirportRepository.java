package com.keyin.Airport;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AirportRepository extends CrudRepository<Airport, Long> {
    public Airport findByName(String name);
    public Airport findByCode(String code);
}

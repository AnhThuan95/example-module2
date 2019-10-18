package com.codegym.springcityproject.service;

import com.codegym.springcityproject.model.City;

import java.util.Optional;

public interface CityService {
    Iterable<City> findAll();

    Optional<City> findById(Long id);

    void save(City city);

    void remove(Long id);
}

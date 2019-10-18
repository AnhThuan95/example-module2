package com.codegym.springcityproject.service.impl;

import com.codegym.springcityproject.model.City;
import com.codegym.springcityproject.repository.CityRepository;
import com.codegym.springcityproject.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRepository.deleteById(id);
    }
}

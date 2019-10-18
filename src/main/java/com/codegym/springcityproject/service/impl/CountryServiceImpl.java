package com.codegym.springcityproject.service.impl;

import com.codegym.springcityproject.model.Country;
import com.codegym.springcityproject.repository.CountryRepository;
import com.codegym.springcityproject.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CountryServiceImpl implements CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public void save(Country country) {
        countryRepository.save(country);
    }

    @Override
    public void remove(Long id) {
        countryRepository.deleteById(id);
    }
}

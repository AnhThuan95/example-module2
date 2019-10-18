package com.codegym.springcityproject.service;

import com.codegym.springcityproject.model.Country;

import java.util.Optional;

public interface CountryService {
    Iterable<Country> findAll();

    Optional<Country> findById(Long id);

    void save(Country country);

    void remove(Long id);
}

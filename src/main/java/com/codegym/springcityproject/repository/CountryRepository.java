package com.codegym.springcityproject.repository;

import com.codegym.springcityproject.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Long> {
}

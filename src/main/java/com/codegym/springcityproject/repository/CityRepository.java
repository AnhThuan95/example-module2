package com.codegym.springcityproject.repository;

import com.codegym.springcityproject.model.City;
import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository<City, Long> {
}

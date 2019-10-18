package com.codegym.springcityproject.validator;

import com.codegym.springcityproject.model.City;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CityValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return City.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        City city = (City) target;
        String name = city.getName();
        Long area = city.getArea();
        Long population = city.getPopulation();
        Long gdp = city.getGdp();
        String introduction = city.getIntroduction();
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
        if (area != null && area <= 0) {
            errors.rejectValue("area", "area.positive");
        }
        if (population!= null && population <= 0) {
            errors.rejectValue("population", "population.positive");
        }
        if (gdp!= null && gdp <= 0) {
            errors.rejectValue("gdp", "gdp.positive");
        }

    }
}

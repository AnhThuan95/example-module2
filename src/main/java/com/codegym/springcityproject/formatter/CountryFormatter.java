package com.codegym.springcityproject.formatter;

import com.codegym.springcityproject.model.Country;
import com.codegym.springcityproject.service.CountryService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class CountryFormatter implements Formatter<Optional<Country>> {
    private CountryService countryService;

    public CountryFormatter(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    public Optional<Country> parse(String text, Locale locale) throws ParseException {
        return countryService.findById(Long.valueOf(text));
    }

    @Override
    public String print(Optional<Country> object, Locale locale) {
        return object.toString();
    }
}

package com.codegym.springcityproject.controller;

import com.codegym.springcityproject.model.City;
import com.codegym.springcityproject.model.Country;
import com.codegym.springcityproject.service.CityService;
import com.codegym.springcityproject.service.CountryService;
import com.codegym.springcityproject.validator.CityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @ModelAttribute("countries")
    public Iterable<Country> allManufacturers() {
        return countryService.findAll();
    }

    @GetMapping("/")
    public ModelAndView showList() {
        Iterable<City> cities = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createCity() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createdCity(@Valid @ModelAttribute("city") City city, BindingResult bindingResult) {
        new CityValidator().validate(city, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("/create");
        }

        cityService.save(city);

        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "New city created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView createCity(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editedCity(@Valid @ModelAttribute("city") City city, BindingResult bindingResult) {
        new CityValidator().validate(city, bindingResult);
        ModelAndView modelAndView = new ModelAndView("/edit");
        if (!bindingResult.hasFieldErrors()) {
            cityService.save(city);

            modelAndView.addObject("message", "City updated successfully");
        }
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewCity(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("city", city.get());
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView deleteCity(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/delete");
        modelAndView.addObject("city", city.get());
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deletedCity(@ModelAttribute("city") City city) {
        cityService.remove(city.getId());

        ModelAndView modelAndView = new ModelAndView("redirect:/");
        return modelAndView;
    }
}

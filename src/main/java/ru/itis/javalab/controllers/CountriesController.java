package ru.itis.javalab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.javalab.services.CountryService;

@Controller
public class CountriesController {

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public String getCountriesPage(@RequestParam(value = "continent", required = false) Integer id,
                               Model model) {
        if (id != null) {
            model.addAttribute("countries", countryService.getAllCountriesByContinent(id));
        } else {
            model.addAttribute("countries", countryService.getAllCountries());
        }
        return "countries_page";
    }


}

package ru.itis.javalab.services;

import ru.itis.javalab.models.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();
    List<Country> getAllCountriesByContinent(int id);
}

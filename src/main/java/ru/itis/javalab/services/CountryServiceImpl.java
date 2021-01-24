package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.javalab.models.Continent;
import ru.itis.javalab.models.Country;
import ru.itis.javalab.repositories.CountryRepository;

import java.util.List;

public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public List<Country> getAllCountriesByContinent(int id) {
        return countryRepository.findAllById(id);
    }
}

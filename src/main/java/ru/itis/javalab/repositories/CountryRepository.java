package ru.itis.javalab.repositories;

import ru.itis.javalab.models.Country;

import java.util.List;

public interface CountryRepository extends CrudRepository<Country> {
    public List<Country> findAllById(int id);
}

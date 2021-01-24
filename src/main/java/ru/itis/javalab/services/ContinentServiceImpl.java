package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.javalab.models.Comment;
import ru.itis.javalab.models.Continent;
import ru.itis.javalab.repositories.ContinentRepository;

import java.util.List;

public class ContinentServiceImpl implements ContinentService {

    @Autowired
    private ContinentRepository continentRepository;

    public ContinentServiceImpl(ContinentRepository continentRepository) {
        this.continentRepository = continentRepository;
    }

    @Override
    public List<Continent> getAllContinents() {
        return continentRepository.findAll();
    }
}

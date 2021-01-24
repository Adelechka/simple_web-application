package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.javalab.models.Shipping;
import ru.itis.javalab.repositories.ShippingRepository;

import java.util.List;

public class ShippingServiceImpl implements ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;

    public ShippingServiceImpl(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    @Override
    public List<Shipping> getAllShipping() {
        return shippingRepository.findAll();
    }
}

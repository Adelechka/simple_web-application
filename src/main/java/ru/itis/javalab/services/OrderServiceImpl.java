package ru.itis.javalab.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.itis.javalab.dto.OrderDto;
import ru.itis.javalab.models.Order;
import ru.itis.javalab.repositories.OrderRepository;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public void saveOrder(OrderDto order) {
        orderRepository.save(order);
    }
}

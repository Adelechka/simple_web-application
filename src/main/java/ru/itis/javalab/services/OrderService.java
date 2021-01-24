package ru.itis.javalab.services;

import ru.itis.javalab.dto.OrderDto;
import ru.itis.javalab.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    void saveOrder(Order order);
    void saveOrder(OrderDto order);
}

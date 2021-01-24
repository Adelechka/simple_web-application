package ru.itis.javalab.repositories;

import ru.itis.javalab.dto.OrderDto;
import ru.itis.javalab.models.Order;

public interface OrderRepository extends CrudRepository<Order> {
    void save(OrderDto entity);
}

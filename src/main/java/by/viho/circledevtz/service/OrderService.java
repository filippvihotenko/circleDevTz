package by.viho.circledevtz.service;

import by.viho.circledevtz.domain.Order;

import java.util.List;

public interface OrderService
{
    List<Order> findAll();

    Order createOrder(Order order);
}

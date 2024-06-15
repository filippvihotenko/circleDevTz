package by.viho.circledevtz.service;

import by.viho.circledevtz.domain.Order;
import by.viho.circledevtz.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService
{
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }
    @Override
    public List<Order> findAll()
    {
        return orderRepository.findAll();
    }
    @Override
    public Order createOrder(Order order){
        return orderRepository.save(order);
    }
}

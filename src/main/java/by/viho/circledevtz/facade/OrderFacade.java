package by.viho.circledevtz.facade;

import by.viho.circledevtz.DTO.OrderDTO;
import by.viho.circledevtz.DTO.ProductDTO;
import by.viho.circledevtz.domain.Order;
import by.viho.circledevtz.domain.Product;
import by.viho.circledevtz.mapper.MapperConfig;
import by.viho.circledevtz.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderFacade
{
    private OrderService orderService;
    private MapperConfig mapperConfig;

    @Autowired
    public OrderFacade(OrderService orderService)
    {
        this.orderService = orderService;
    }

    public List<OrderDTO> findAllProducts(){
        return this.orderService.findAll()
                .stream().map(order -> mapperConfig.convertTo(order, OrderDTO.class)).collect(Collectors.toList());
    }
    public OrderDTO createOrder(OrderDTO orderDTO){
        Order order = this.orderService.createOrder(mapperConfig.convertTo(orderDTO, Order.class));
        return mapperConfig.convertTo(order, OrderDTO.class )     ;
    }
}

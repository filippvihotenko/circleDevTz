package by.viho.circledevtz.controller;

import by.viho.circledevtz.DTO.OrderDTO;
import by.viho.circledevtz.facade.OrderFacade;
import by.viho.circledevtz.facade.ProductFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController
{
    private OrderFacade orderFacade;
    private ProductFacade productFacade;

    @Autowired
    public OrderController(OrderFacade orderFacade, ProductFacade productFacade)
    {
        this.orderFacade = orderFacade;
        this.productFacade = productFacade;
    }

    @GetMapping("/all")
    public List<OrderDTO> getAllOrders(){
        return this.orderFacade.findAllProducts();
    }

    @PostMapping("/create")
    public ResponseEntity<HttpStatus> createOrder(@RequestBody OrderDTO orderDTO)
    {
        this.orderFacade.createOrder(orderDTO);
        Date date = new Date();
        System.out.println(date);
        return ResponseEntity.ok(HttpStatus.OK);

    }
}

package by.viho.circledevtz.DTO;

import by.viho.circledevtz.domain.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class OrderDTO
{
    private Date orderDate;

    private String region;

    private Set<Product> products;

    public OrderDTO(Date orderDate, String region, Set<Product> products)
    {
        this.orderDate = orderDate;
        this.region = region;
        this.products = products;
    }

    public OrderDTO()
    {
    }
}

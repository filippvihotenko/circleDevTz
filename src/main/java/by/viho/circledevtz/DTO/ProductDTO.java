package by.viho.circledevtz.DTO;


import by.viho.circledevtz.domain.Order;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class ProductDTO
{
    @NotNull
    @Size(min = 3, max = 30)
    private String  title;

    @NotNull
    @Size(max = 200)
    private String description;


    private Set<Order> orders;


    public ProductDTO()
    {
    }

    public ProductDTO(String title, String description, Set<Order> orders)
    {
        this.title = title;
        this.description = description;
        this.orders = orders;
    }
}

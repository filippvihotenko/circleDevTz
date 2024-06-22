package by.viho.circledevtz.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(schema = "circledev",name = "product")
public class Product
{

    @Id
    @Column(name = "product_id")
    private UUID product_id;
    @Column(name = "title")
    @NotNull
    @Size(min = 3, max = 30)
    private String  title;


    @Column(name = "description")
    @NotNull
    @Size(max = 200)
    private String description;

    @Column(name = "timestamp")
    private ZonedDateTime createdAt;


    @ManyToMany(mappedBy = "products")
    private Set<Order> orders;

    public Product()
    {
        this.product_id = UUID.randomUUID();
    }
}

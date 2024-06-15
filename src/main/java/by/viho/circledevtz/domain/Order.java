package by.viho.circledevtz.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(schema = "circledev",name = "order")
public class Order
{
    @Id
    @Column(name = "order_id")
    private UUID order_id;

    @Column(name = "order_date")
    @PastOrPresent
    private Date orderDate;

    @Column(name = "region")
    private String region;

    @ManyToMany
    @JoinTable(name = "OrderProduct",  joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;

}

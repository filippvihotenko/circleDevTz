package by.viho.circledevtz.domain;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "Person")
public class Person
{
    @Id
    private UUID uuid;
    @Column(unique = true)
    private String username;
    private String password;
    private String role;

    public Person()
    {
        this.uuid = UUID.randomUUID();
    }
}

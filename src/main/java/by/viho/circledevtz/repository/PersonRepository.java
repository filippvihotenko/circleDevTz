package by.viho.circledevtz.repository;

import by.viho.circledevtz.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID>
{
    Optional<Person> findByUsername(String username);
}

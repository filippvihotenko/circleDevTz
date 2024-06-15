package by.viho.circledevtz.configuration;


import by.viho.circledevtz.domain.Person;
import by.viho.circledevtz.repository.PersonRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;


public class MyUserDetailService implements UserDetailsService
{
    private PersonRepository personRepository;


    public MyUserDetailService(PersonRepository personRepository)
    {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        Optional<Person> person = personRepository.findByUsername(username);

        return person.map(MyUserDetails::new).orElseThrow(()-> new UsernameNotFoundException(username + "There is not such user"));
    }
}

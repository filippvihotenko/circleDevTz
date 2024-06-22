
package by.viho.circledevtz.configuration;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Bean;

public class FlywayConfig
{
    @Bean
    public void setFlyway(){
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5434/circledev", "circledev", "circledev")
                .load();

        flyway.baseline();

        flyway.migrate();
    }
}




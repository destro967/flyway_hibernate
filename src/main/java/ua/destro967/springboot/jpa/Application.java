package ua.destro967.springboot.jpa;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.destro967.springboot.jpa.Book.BookRepository;

@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Bean
    public String runner(BookRepository repository){
        return repository.findAll().toString();
    }

    @Bean(initMethod = "migrate")
    public Flyway flyway() {
        Flyway fly = new Flyway();
        fly.setDataSource("jdbc:postgresql:books_test","test","test");
        fly.setLocations("filesystem:src/main/resources/db/migration");

        fly.migrate();
        return fly;
    }
}

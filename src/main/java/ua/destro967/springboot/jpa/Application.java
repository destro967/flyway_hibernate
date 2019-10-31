package ua.destro967.springboot.jpa;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.destro967.springboot.jpa.Book.BookRepository;

@SpringBootApplication
@Slf4j
public class Application {

    org.slf4j.Logger  slf4jLog = org.slf4j.LoggerFactory.getLogger("test");


    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

    @Bean
    public CommandLineRunner runner(BookRepository repository){
        return r -> slf4jLog.info(repository.findAll().toString());
    }
}

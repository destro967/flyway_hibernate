import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }


    @Bean(initMethod = "migrate")
    public Flyway flyway(){
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:postgresql:books_test","test","test");
        flyway.setLocations("filesystem:src/main/resources/db/migration");

        flyway.migrate();
        return flyway;
    }
}
